package com.apirest.webflux.functional;

import static org.springframework.web.reactive.function.server.RequestPredicates.*;
import static org.springframework.web.reactive.function.server.RequestPredicates.accept;
import static org.springframework.web.reactive.function.server.RouterFunctions.route;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.ServerResponse;

@Configuration
public class ProductFunctionalConfiguration {

    @Bean
    public RouterFunction<ServerResponse> createRoutes(ProductHandler productHandler) {
        return route(POST("/functional/products").and(accept(MediaType.APPLICATION_JSON)), productHandler::save)
        .andRoute(GET("/functional/products").and(accept(MediaType.APPLICATION_JSON)), productHandler::getAllProducts)
        .andRoute(GET("/functional/products/{id}").and(accept(MediaType.APPLICATION_JSON)), productHandler::getById)
        .andRoute(DELETE("/functional/products/{id}").and(accept(MediaType.APPLICATION_JSON)), productHandler::deleteById);
    }
}
