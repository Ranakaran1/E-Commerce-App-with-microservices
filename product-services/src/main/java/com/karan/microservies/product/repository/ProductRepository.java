package com.karan.microservies.product.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.karan.microservies.product.model.Product;

public interface ProductRepository extends MongoRepository<Product, String>{

    

    
}
