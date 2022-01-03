package com.balabasciuc.axonframework.axoncqrsexample.common_to_both;

public class BookActivedEvent extends BaseEvent<String> {

    private String bookStatus;

    public BookActivedEvent(String id, String bookStatus) {
        super(id);
        this.bookStatus = bookStatus;
    }

    public String getBookStatus() {
        return bookStatus;
    }
}
