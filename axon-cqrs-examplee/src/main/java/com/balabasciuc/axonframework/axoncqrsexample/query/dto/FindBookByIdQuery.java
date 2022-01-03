package com.balabasciuc.axonframework.axoncqrsexample.query.dto;

public class FindBookByIdQuery {

    private String bookId;

    public FindBookByIdQuery(String bookId) {
        this.bookId = bookId;
    }

    public String getBookId() {
        return bookId;
    }
}
