package com.apirest.webflux.functional;

import com.apirest.webflux.data.Product;
import com.apirest.webflux.service.ProductService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.reactive.function.BodyInserters;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;

import reactor.core.publisher.Mono;

@Component
public class ProductHandler {

    @Autowired
    ProductService productService;
    Mono<ServerResponse> notFound = ServerResponse.notFound().build();

    public Mono<ServerResponse> save(ServerRequest request) {
        Mono<Product> product = request.bodyToMono(Product.class);
        return ServerResponse.accepted().contentType(MediaType.APPLICATION_JSON)
                .body(BodyInserters.fromPublisher(product.flatMap(productService::save), Product.class));

    }

    public Mono<ServerResponse> getAllProducts(ServerRequest request) {
        return ServerResponse.ok().contentType(MediaType.APPLICATION_JSON).body(productService.getAllProducts(),
                Product.class);
    }

    public Mono<ServerResponse> deleteById(ServerRequest request) {
        String id = request.pathVariable("id");
        Mono<Void> deleted = productService.deleteById(id);
        return ServerResponse.ok().contentType(MediaType.APPLICATION_JSON).body(deleted, Void.class);
    }
        
    public Mono<ServerResponse> getById(ServerRequest request) {
        String id = String.valueOf(request.pathVariable("id"));
        Mono<Product> productMono = productService.getById(id);
        
        return  productMono.flatMap(
                product -> ServerResponse.ok().contentType(MediaType.APPLICATION_JSON).body(productMono, Product.class))
                .switchIfEmpty(notFound);

    }

}
