package com.balabasciuc.axonframework.axon_cqrs_single_jvm.product.command.service;

import com.balabasciuc.axonframework.axon_cqrs_single_jvm.product.command.commands.ProductCreatedCommand;
import com.balabasciuc.axonframework.axon_cqrs_single_jvm.product.command.dto.CreateProductRequest;
import com.balabasciuc.axonframework.axon_cqrs_single_jvm.product.query.repository.ProductRepository;
import org.axonframework.commandhandling.gateway.CommandGateway;
import org.springframework.stereotype.Service;

import java.util.UUID;
import java.util.concurrent.CompletableFuture;

@Service
public class ProductService {

    private final CommandGateway commandGateway;

    public ProductService(CommandGateway commandGateway) {
        this.commandGateway = commandGateway;
    }

    public CompletableFuture<String> createProduct(CreateProductRequest request)
    {
        return commandGateway.send(new ProductCreatedCommand(UUID.randomUUID().toString(), request.getProductPrice(), request.getProductStock(), request.getProductDescription()));
    }
}
