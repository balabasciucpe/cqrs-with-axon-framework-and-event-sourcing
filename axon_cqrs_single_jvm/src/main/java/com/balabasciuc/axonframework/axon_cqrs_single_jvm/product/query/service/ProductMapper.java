package com.balabasciuc.axonframework.axon_cqrs_single_jvm.product.query.service;

import com.balabasciuc.axonframework.axon_cqrs_single_jvm.product.command.dto.ProductDTO;
import com.balabasciuc.axonframework.axon_cqrs_single_jvm.product.query.model.Product;
import org.springframework.stereotype.Component;


//low level mapper

@Component
public class ProductMapper {

    public ProductDTO mapEntityToDTO(Product product) {
        ProductDTO productDTO = new ProductDTO();
        if ((product.getProductId() != null) && (product.getProductPrice() > 0) &&
                (product.getProductStock() > 0) && (product.getProductDescription() != null)) {
            productDTO.setProductId(product.getProductId());
            productDTO.setProductPrice(product.getProductPrice());
            productDTO.setProductStock(product.getProductStock());
            productDTO.setProductDescription(product.getProductDescription());
        }
        return productDTO;
    }
}
