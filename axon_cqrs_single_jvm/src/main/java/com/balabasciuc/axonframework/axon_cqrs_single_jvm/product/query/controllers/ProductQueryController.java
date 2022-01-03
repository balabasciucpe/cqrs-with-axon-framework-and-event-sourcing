package com.balabasciuc.axonframework.axon_cqrs_single_jvm.product.query.controllers;

import com.balabasciuc.axonframework.axon_cqrs_single_jvm.product.command.dto.ProductDTO;
import com.balabasciuc.axonframework.axon_cqrs_single_jvm.product.query.dto.FindAllProductsRequest;
import org.axonframework.messaging.responsetypes.ResponseTypes;
import org.axonframework.queryhandling.QueryGateway;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/products")
public class ProductQueryController {

    private final QueryGateway queryGateway;


    public ProductQueryController(QueryGateway queryGateway) {
        this.queryGateway = queryGateway;
    }

    @GetMapping(value = "/all")
    public ResponseEntity<List<ProductDTO>> getAllProducts() {
        List<ProductDTO> products = (List<ProductDTO>) queryGateway.query(new FindAllProductsRequest(), ResponseTypes.multipleInstancesOf(ProductDTO.class)).join();

        return new ResponseEntity<List<ProductDTO>>(products, HttpStatus.ACCEPTED);


    }
}
