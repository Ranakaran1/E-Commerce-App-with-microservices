package com.karan.microservies.product.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.karan.microservies.product.dto.ProductRequest;
import com.karan.microservies.product.dto.ProductResponse;
import com.karan.microservies.product.model.Product;
import com.karan.microservies.product.repository.ProductRepository;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Service
@RequiredArgsConstructor
@Slf4j
public class ProductService {
    
    private final ProductRepository productRepository;

    public ProductResponse createProduct(ProductRequest productRequest){
        Product product = Product.builder().name(productRequest.name())
            .description(productRequest.description())
            .price(productRequest.price())
            .build();

            log.info("Product created successfully");

        productRepository.save(product);
        return  new ProductResponse(product.getId(), product.getName(), product.getDescription(), product.getPrice());
    }

    public List<ProductResponse> getAllProducts() {
        return productRepository.findAll().stream()
        .map(product -> new ProductResponse(product.getId(), product.getName(), product.getDescription(), product.getPrice()))
        .toList();
    }


}
