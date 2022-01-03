package com.balabasciuc.axonframework.axon_cqrs_single_jvm.product.command.Aggregate;

import com.balabasciuc.axonframework.axon_cqrs_single_jvm.product.command.commands.ProductCreatedCommand;
import com.balabasciuc.axonframework.axon_cqrs_single_jvm.product.command.dto.CreateProductRequest;
import com.balabasciuc.axonframework.axon_cqrs_single_jvm.product.command.events.ProductCreatedEvent;
import lombok.extern.java.Log;
import lombok.extern.slf4j.Slf4j;
import org.axonframework.commandhandling.CommandHandler;
import org.axonframework.eventsourcing.EventSourcingHandler;
import org.axonframework.modelling.command.AggregateIdentifier;
import org.axonframework.modelling.command.AggregateLifecycle;
import org.axonframework.spring.stereotype.Aggregate;

@Aggregate
@Slf4j
public class ProductAggregate {


    @AggregateIdentifier
    private String productAggregateId;

    private Double price;
    private Integer stockNumber;
    private String productDescription;

    public ProductAggregate() {
    }

    @CommandHandler
    public ProductAggregate(ProductCreatedCommand productCreatedCommand)
    {
        log.info("Received ProductCreatedCommand... ");
        AggregateLifecycle.apply(new ProductCreatedEvent(productCreatedCommand.getId(), productCreatedCommand.getProductPrice(), productCreatedCommand.getProductNumber(), productCreatedCommand.getProductDescription()));
    }

    @EventSourcingHandler
    public void on(ProductCreatedEvent productCreatedEvent)
    {
        log.info("Receiving ProductCreatedEvent... ");
        this.productAggregateId = productCreatedEvent.getId();
        this.price = productCreatedEvent.getProductPrice();
        this.stockNumber = productCreatedEvent.getProductStock();
        this.productDescription = productCreatedEvent.getProductDescription();
    }


}
