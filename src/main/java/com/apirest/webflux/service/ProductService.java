package com.apirest.webflux.service;

import com.apirest.webflux.data.Product;
import com.apirest.webflux.repository.ProductRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.reactive.function.server.ServerResponse;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class ProductService {

    @Autowired
    ProductRepository repository;

    public Mono<Product> save(final Product product) {
        return repository.save(product);
    }

    public Flux<Product> getAllProducts() {
        return repository.findAll();
    }

    public Mono<Void> deleteById(final String id) {
        return repository.deleteById(id);
    }

    public Mono<Product> getById(final String id) {
        return repository.findById(id);
    }
}
