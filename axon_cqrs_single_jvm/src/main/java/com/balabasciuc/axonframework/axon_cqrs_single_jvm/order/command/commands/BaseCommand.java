package com.balabasciuc.axonframework.axon_cqrs_single_jvm.order.command.commands;

import org.axonframework.modelling.command.TargetAggregateIdentifier;

public abstract class BaseCommand<T> {

    @TargetAggregateIdentifier
    private T id;

    public BaseCommand(T id) {
        this.id = id;
    }

    public T getId() {
        return id;
    }
}
