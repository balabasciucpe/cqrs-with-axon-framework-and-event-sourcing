package com.balabasciuc.axonframework.axoncqrsexample.query.model;

import com.balabasciuc.axonframework.axoncqrsexample.command.aggregate.BookDetails;

import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

//Book is our QueryModel
@Entity
@Table(name = "books")
public class Book {


    @Id
    private String bookId;

    private @Embedded
    BookDetails bookDetails;
    private String bookStatus;

    public Book() {
    }

    public Book(String bookId, BookDetails bookDetails, String bookStatus) {
        this.bookId = bookId;
        this.bookDetails = bookDetails;
        this.bookStatus = bookStatus;
    }

    public String getBookId() {
        return bookId;
    }

    public void setBookId(String bookId) {
        this.bookId = bookId;
    }

    public BookDetails getBookDetails() {
        return bookDetails;
    }

    public void setBookDetails(BookDetails bookDetails) {
        this.bookDetails = bookDetails;
    }

    public String getBookStatus() {
        return bookStatus;
    }

    public void setBookStatus(String bookStatus) {
        this.bookStatus = bookStatus;
    }

    //methods, guards

}
