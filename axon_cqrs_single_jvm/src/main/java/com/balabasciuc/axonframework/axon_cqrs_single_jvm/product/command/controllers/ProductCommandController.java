package com.balabasciuc.axonframework.axon_cqrs_single_jvm.product.command.controllers;

import com.balabasciuc.axonframework.axon_cqrs_single_jvm.product.command.dto.CreateProductRequest;
import com.balabasciuc.axonframework.axon_cqrs_single_jvm.product.command.service.ProductService;
import org.hibernate.exception.GenericJDBCException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.CompletableFuture;

@RestController
@RequestMapping(value = "/products")
public class ProductCommandController {

    private ProductService productService;

    public ProductCommandController(ProductService productService) {
        this.productService = productService;
    }

    @PostMapping(value = "/")
    public ResponseEntity<String> createProduct(@RequestBody CreateProductRequest createProductRequest)
    {
        try {
            CompletableFuture<String> response = productService.createProduct(createProductRequest);
            return new ResponseEntity<>(response.get(), HttpStatus.CREATED);
        } catch(Exception e)
        {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }
}
