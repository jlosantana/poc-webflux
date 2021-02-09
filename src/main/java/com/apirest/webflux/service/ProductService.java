package com.apirest.webflux.service;

import com.apirest.webflux.data.Product;
import com.apirest.webflux.repository.ProductRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
}
