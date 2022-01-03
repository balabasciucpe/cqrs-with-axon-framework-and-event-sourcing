package com.balabasciuc.axonframework.axoncqrsexample.command.commands;


import com.balabasciuc.axonframework.axoncqrsexample.command.aggregate.BookDetails;

public class CreateBookCommand extends BaseCommand<String> {

    //value Obj = DDD

    private BookDetails bookDetails;

    public CreateBookCommand(String id, BookDetails bookDetails) {
        super(id);
        this.bookDetails = bookDetails;
    }

    public BookDetails getBookDetails() {
        return bookDetails;
    }
}
