package com.balabasciuc.axonframework.axon_cqrs_single_jvm.product.query.dto;

import com.balabasciuc.axonframework.axon_cqrs_single_jvm.product.query.model.Product;
import lombok.Data;

import java.util.List;

@Data
public class FindAllProductsRequest {

    public List<Product> allProducts;


}
