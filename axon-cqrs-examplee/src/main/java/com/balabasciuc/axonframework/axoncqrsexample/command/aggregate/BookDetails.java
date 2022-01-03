package com.balabasciuc.axonframework.axoncqrsexample.command.aggregate;


import javax.persistence.Embeddable;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

//value Obj class
@Embeddable
public class BookDetails {

    @NotBlank @Size(min = 5, max = 40) //message = {"Title of the book should be between  (min) (max) " })
    private String bookTitle;
    @NotBlank
    private String bookAuthor;
    @NotBlank
    private String bookDescription;
    @NotNull
    private Integer price;

    protected BookDetails() {
    }

    public BookDetails(String bookTitle, String bookAuthor, String bookDescription, Integer price) {
        this.bookTitle = bookTitle;
        this.bookAuthor = bookAuthor;
        this.bookDescription = bookDescription;
        this.price = price;
    }

    public String getBookTitle() {
        return bookTitle;
    }

    public void setBookTitle(String bookTitle) {
        this.bookTitle = bookTitle;
    }

    public String getBookAuthor() {
        return bookAuthor;
    }

    public void setBookAuthor(String bookAuthor) {
        this.bookAuthor = bookAuthor;
    }

    public String getBookDescription() {
        return bookDescription;
    }

    public void setBookDescription(String bookDescription) {
        this.bookDescription = bookDescription;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }


}
