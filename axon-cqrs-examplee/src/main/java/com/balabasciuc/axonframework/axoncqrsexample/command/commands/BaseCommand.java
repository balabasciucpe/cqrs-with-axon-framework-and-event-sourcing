package com.balabasciuc.axonframework.axoncqrsexample.command.commands;

import org.axonframework.modelling.command.TargetAggregateIdentifier;

//nu vrem sa fie instantiata dar vrem sa o folosim ca un template pentru un anumit grup de clasa(comenzi)
//folosim generics pt. flexibilitate
public abstract class BaseCommand<T> {

    //axon specific, trebe sa stim carei instante a aggregatului aplicam aceasta comanda
    @TargetAggregateIdentifier
    private T id;


    public BaseCommand(T id) {
        this.id = id;
    }

    public T getId() {
        return id;
    }

    //setam valoarea in constructor, setter am putea folosi pentru garzi
    //metode specifice clasei acesteia conform DDD
}
