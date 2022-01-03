package com.balabasciuc.axonframework.axon_cqrs_single_jvm.order.query.service;

import com.balabasciuc.axonframework.axon_cqrs_single_jvm.order.command.events.OrderCreatedEvent;
import com.balabasciuc.axonframework.axon_cqrs_single_jvm.order.query.dto.FindOrderByOrderIdQuery;
import com.balabasciuc.axonframework.axon_cqrs_single_jvm.order.query.dto.FindOrdersQuery;
import com.balabasciuc.axonframework.axon_cqrs_single_jvm.order.query.model.Order;
import com.balabasciuc.axonframework.axon_cqrs_single_jvm.order.query.repository.OrderRepository;
import lombok.extern.slf4j.Slf4j;
import org.axonframework.eventhandling.EventHandler;
import org.axonframework.queryhandling.QueryHandler;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Slf4j
public class OrderQueryService {

    private final OrderRepository orderRepository;

    public OrderQueryService(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    @EventHandler
    public void on(OrderCreatedEvent orderCreatedEvent) {
        log.info("Handling OrderCreatedEvent... Starting");
        Order order = new Order(orderCreatedEvent.getId(), orderCreatedEvent.getPrice(), orderCreatedEvent.getNumber());
        order.setOrderStatus("NEW");
        orderRepository.save(order);
    }

    @QueryHandler
    public Order findOrderByOrderId(FindOrderByOrderIdQuery query) {
        log.info("Handling FindOrderByOrderIdQuery... Starting");
        //guards
        return orderRepository.findById(query.getOrderId()).get();

    }

    @QueryHandler
    public List<Order> handle(FindOrdersQuery query) {
        log.info("Handling GetAlOrdersQuery... Starting.");
        return orderRepository.findAll();
    }
}
