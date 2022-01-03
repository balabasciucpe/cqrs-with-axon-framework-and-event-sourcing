package com.balabasciuc.axonframework.axon_cqrs_single_jvm.order.command.controller;

import com.balabasciuc.axonframework.axon_cqrs_single_jvm.order.command.dto.CreateOrderRequest;
import com.balabasciuc.axonframework.axon_cqrs_single_jvm.order.command.service.OrderCommandService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ConcurrentModificationException;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

@RestController
@RequestMapping(value = "/orders")
public class OrderCommandController {

    private final OrderCommandService orderCommandService;

    public OrderCommandController(OrderCommandService orderCommandService) {
        this.orderCommandService = orderCommandService;
    }

    @PostMapping(value = "/")
    public ResponseEntity<String> createOrder(@RequestBody CreateOrderRequest createOrderRequest) {
        try {
            CompletableFuture<String> response = orderCommandService.createOrder(createOrderRequest);
            return new ResponseEntity<>(response.get(), HttpStatus.CREATED);
        } catch (InterruptedException | ExecutionException e) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
    }
}
