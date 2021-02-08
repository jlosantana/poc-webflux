package com.apirest.webflux.repository;

import com.apirest.webflux.data.Product;

import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

public interface ProductRepository extends ReactiveMongoRepository<Product, String> {

}
