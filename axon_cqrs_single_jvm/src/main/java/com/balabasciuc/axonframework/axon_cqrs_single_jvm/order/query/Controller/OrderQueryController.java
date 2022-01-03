package com.balabasciuc.axonframework.axon_cqrs_single_jvm.order.query.Controller;


import com.balabasciuc.axonframework.axon_cqrs_single_jvm.order.query.dto.FindOrderByOrderIdQuery;
import com.balabasciuc.axonframework.axon_cqrs_single_jvm.order.query.dto.FindOrdersQuery;
import com.balabasciuc.axonframework.axon_cqrs_single_jvm.order.query.model.Order;
import org.axonframework.messaging.responsetypes.ResponseTypes;
import org.axonframework.queryhandling.QueryGateway;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/order-query")
public class OrderQueryController {

    private final QueryGateway queryGateway;

    public OrderQueryController(QueryGateway queryGateway) {
        this.queryGateway = queryGateway;
    }

    @GetMapping(value = "/orderId")
    public ResponseEntity<Order> findOrderByOrderId(@RequestParam String orderId) {
        Order order = queryGateway.query(new FindOrderByOrderIdQuery(orderId), Order.class).join();
        if (order != null) {
            return new ResponseEntity<>(order, HttpStatus.ACCEPTED);
        } else {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
    }

    @GetMapping(value = "/all", produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<List<Order>> getAllOrders() {
        List<Order> orders = (List<Order>) queryGateway.query(new FindOrdersQuery(), ResponseTypes.multipleInstancesOf(Order.class)).join();
        return new ResponseEntity<>(orders, HttpStatus.ACCEPTED);
    }


}
