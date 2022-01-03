package com.balabasciuc.axonframework.axoncqrsexample.common_to_both;

//la fel ca in cazul lui BaseCommand
public abstract class BaseEvent<T> {

    private T id;

    public T getId() {
        return id;
    }

    public BaseEvent(T id) {
        this.id = id;
    }


}
