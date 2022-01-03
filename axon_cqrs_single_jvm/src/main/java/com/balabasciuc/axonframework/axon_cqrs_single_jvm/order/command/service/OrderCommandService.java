package com.balabasciuc.axonframework.axon_cqrs_single_jvm.order.command.service;

import com.balabasciuc.axonframework.axon_cqrs_single_jvm.order.command.commands.NewOrderCommand;
import com.balabasciuc.axonframework.axon_cqrs_single_jvm.order.command.dto.CreateOrderRequest;
import org.axonframework.commandhandling.gateway.CommandGateway;
import org.springframework.stereotype.Service;

import java.util.UUID;
import java.util.concurrent.CompletableFuture;

@Service
public class OrderCommandService {

    private final CommandGateway commandGateway;

    public OrderCommandService(CommandGateway commandGateway) {
        this.commandGateway = commandGateway;
    }

    public CompletableFuture<String> createOrder(CreateOrderRequest createOrderRequest) {
        return commandGateway.send(new NewOrderCommand(UUID.randomUUID().toString(), createOrderRequest.getPrice(), createOrderRequest.getNumber()));
    }
}



