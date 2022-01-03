package com.balabasciuc.axonframework.axoncqrsexample.query.dto;

public class FindBookByTitleQuery {

    private String bookTitle;

    public FindBookByTitleQuery(String bookTitle) {
        this.bookTitle = bookTitle;
    }

    public String getBookTitle() {
        return bookTitle;
    }
}
