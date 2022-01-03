package com.balabasciuc.axonframework.axoncqrsexample.common_to_both;

public class BookDeletedEvent extends BaseEvent<String> {


    public BookDeletedEvent(String id) {
        super(id);
    }


}
