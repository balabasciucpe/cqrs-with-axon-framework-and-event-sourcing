package com.balabasciuc.axonframework.axon_cqrs_single_jvm.order.command.commands;

public class NewOrderCommand extends BaseCommand<String> {

    private final Double price;
    private final Integer number;


    public NewOrderCommand(String id, Double price, Integer number) {
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
