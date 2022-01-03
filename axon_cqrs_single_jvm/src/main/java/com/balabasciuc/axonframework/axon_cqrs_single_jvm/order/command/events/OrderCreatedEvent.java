package com.balabasciuc.axonframework.axon_cqrs_single_jvm.order.command.events;

public class OrderCreatedEvent extends BaseEvent<String> {


    private Double price;
    private Integer number;


    public OrderCreatedEvent(String id, Double price, Integer number) {
        super(id);
        this.price = price;
        this.number = number;

    }

    public Double getPrice() {
        return price;
    }

    public Integer getNumber() {
        return number;
    }


}
