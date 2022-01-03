package com.balabasciuc.axonframework.axoncqrsexample.common_to_both;

import com.balabasciuc.axonframework.axoncqrsexample.command.aggregate.BookDetails;

public class BookRevisedEvent extends BaseEvent<String> {

    private BookDetails newBookDetails;

    public BookRevisedEvent(String id, BookDetails newBookDetails) {
        super(id);
        this.newBookDetails = newBookDetails;
    }

    public BookDetails getNewBookDetails() {
        return newBookDetails;
    }
}
