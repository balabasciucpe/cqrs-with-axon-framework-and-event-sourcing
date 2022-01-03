package com.balabasciuc.axonframework.axon_cqrs_single_jvm.order.command.aggregate;

import com.balabasciuc.axonframework.axon_cqrs_single_jvm.order.command.commands.NewOrderCommand;
import com.balabasciuc.axonframework.axon_cqrs_single_jvm.order.command.events.OrderCreatedEvent;
import lombok.extern.slf4j.Slf4j;
import org.axonframework.commandhandling.CommandHandler;
import org.axonframework.eventsourcing.EventSourcingHandler;
import org.axonframework.modelling.command.AggregateIdentifier;
import org.axonframework.modelling.command.AggregateLifecycle;
import org.axonframework.spring.stereotype.Aggregate;

@Aggregate
@Slf4j
public class OrderAggregate {

    @AggregateIdentifier
    private String orderId;

    private Double price;
    private Integer number;
    private String productDescription;
    private OrderStatusEnum orderStatus;

    public OrderAggregate() {
    }

    @CommandHandler
    public OrderAggregate(NewOrderCommand newOrderCommand) {
        log.info("Handling NewOrderCommand... Starting.");
        AggregateLifecycle.apply(new OrderCreatedEvent(newOrderCommand.getId(), newOrderCommand.getPrice(), newOrderCommand.getNumber()));

    }

    @EventSourcingHandler
    public void on(OrderCreatedEvent evt) {
        log.info("Received OrderCreatedEvent... Starting.");
        this.orderId = evt.getId();
        this.number = evt.getNumber();
        this.price = evt.getPrice();

    }


}
