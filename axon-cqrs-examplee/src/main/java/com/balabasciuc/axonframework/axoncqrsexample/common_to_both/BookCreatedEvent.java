package com.balabasciuc.axonframework.axoncqrsexample.common_to_both;

import com.balabasciuc.axonframework.axoncqrsexample.command.aggregate.BookDetails;

public class BookCreatedEvent extends BaseEvent<String> {

    private BookDetails bookDetails;

    public BookCreatedEvent(String id, BookDetails bookDetails) {
        super(id);
        this.bookDetails = bookDetails;
    }

    public BookDetails getBookDetails() {
        return bookDetails;
    }
}
