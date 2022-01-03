package com.balabasciuc.axonframework.axoncqrsexample.command.commands;

import com.balabasciuc.axonframework.axoncqrsexample.command.aggregate.BookDetails;

public class RevisionBookCommand extends BaseCommand<String> {


    private BookDetails newBookDetails;

    public RevisionBookCommand(String id, BookDetails newBookDetails) {
        super(id);
        this.newBookDetails = newBookDetails;
    }

    public BookDetails getNewBookDetails() {
        return newBookDetails;
    }


}
