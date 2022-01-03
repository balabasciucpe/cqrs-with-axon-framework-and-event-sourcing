package com.balabasciuc.axonframework.axon_cqrs_single_jvm.product.query.service;

import com.balabasciuc.axonframework.axon_cqrs_single_jvm.product.command.dto.ProductDTO;
import com.balabasciuc.axonframework.axon_cqrs_single_jvm.product.query.dto.FindAllProductsRequest;
import com.balabasciuc.axonframework.axon_cqrs_single_jvm.product.command.events.ProductCreatedEvent;
import com.balabasciuc.axonframework.axon_cqrs_single_jvm.product.command.events.StockUpdatedEvent;
import com.balabasciuc.axonframework.axon_cqrs_single_jvm.product.query.model.Product;
import com.balabasciuc.axonframework.axon_cqrs_single_jvm.product.query.repository.ProductRepository;
import lombok.extern.slf4j.Slf4j;
import org.axonframework.eventhandling.EventHandler;
import org.axonframework.queryhandling.QueryHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@Slf4j
public class ProductQueryService {

    private final ProductRepository productRepository;

    @Autowired
    private ProductMapper productMapper;

    public ProductQueryService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }


    @EventHandler
    public void on(StockUpdatedEvent stockUpdatedEvent) {
        log.info("ProductModule getting a StockUpdatedEvent... Starting.");
        Product product = new Product();
        product.setProductId(stockUpdatedEvent.getProductId());
        product.depreciateStock(stockUpdatedEvent.getProductStock());
        if (product.getProductStock() != null) {
            product.setProductStock(stockUpdatedEvent.getProductStock());
        }
        product.setProductDescription("ceva");

        productRepository.save(product);

    }

    @QueryHandler
    public List<ProductDTO> handle(FindAllProductsRequest findAllProductsRequest) {
        log.info("Handling FindAllProductsQuery... Starting.");
        List<ProductDTO> productDTOS = new ArrayList<>();
        List<Product> products = productRepository.findAll();

        for (Product productList : products) {
            productDTOS.add(productMapper.mapEntityToDTO(productList));
        }
        return productDTOS;
    }

    @EventHandler
    public void on(ProductCreatedEvent productCreatedEvent)
    {
        log.info("Receiveing OrderCreatedEvent in the ProductQueryService class...");
        productRepository.save(new Product(productCreatedEvent.getId(), productCreatedEvent.getProductPrice(), productCreatedEvent.getProductStock(), productCreatedEvent.getProductDescription()));
    }
}
