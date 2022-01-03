package com.balabasciuc.axonframework.axon_cqrs_single_jvm.product.command.events;

public abstract class BaseEvent<T> {

    private T id;


    public BaseEvent(T id) {
        this.id = id;
    }

    public T getId() {
        return id;
    }
}
