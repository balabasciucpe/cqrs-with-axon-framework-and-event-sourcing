package com.balabasciuc.axonframework.axoncqrsexample.command.dto;

import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Data
public class RevisionBookRequest {


    @NotNull
    private String bookId;

    @NotBlank
    @Size(min = 5, max = 40) //message = {"Title of the book should be between  (min) (max) " })
    private String newBookTitle;
    @NotBlank
    private String newBookAuthor;
    @NotBlank
    private String newBookDescription;
    @NotNull
    private Integer newPrice;
}
