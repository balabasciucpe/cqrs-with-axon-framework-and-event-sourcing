package com.balabasciuc.axonframework.axoncqrsexample.command.controller;

import com.balabasciuc.axonframework.axoncqrsexample.command.dto.CreateBookRequest;
import com.balabasciuc.axonframework.axoncqrsexample.command.dto.DeleteBookRequest;
import com.balabasciuc.axonframework.axoncqrsexample.command.dto.RevisionBookRequest;
import com.balabasciuc.axonframework.axoncqrsexample.command.service.BookAggregateService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

@RestController
@RequestMapping(value = "/books")
public class BookCommandController {

    private BookAggregateService bookAggregateService;

    public BookCommandController(BookAggregateService bookAggregateService) {
        this.bookAggregateService = bookAggregateService;
    }

    @PostMapping(value = "/")
    public ResponseEntity<String> createBook(@RequestBody CreateBookRequest createBookRequest) {
        try {
            CompletableFuture<String> response = bookAggregateService.createBook(createBookRequest);
            return new ResponseEntity<>(response.get(), HttpStatus.CREATED);
        } catch (InterruptedException | ExecutionException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }


    @PutMapping(value = "/revision")
    public ResponseEntity<String> reviseBook(@RequestBody RevisionBookRequest revisionBookRequest) {
        try {
            CompletableFuture<String> response = bookAggregateService.revisionBook(revisionBookRequest);
            return new ResponseEntity<>(response.get(), HttpStatus.ACCEPTED);
        } catch (InterruptedException | ExecutionException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    @DeleteMapping(value = "/delete")
    public ResponseEntity<String> deleteBook(@RequestBody DeleteBookRequest deleteBookRequest) {
        CompletableFuture<String> response = bookAggregateService.deleteBook(deleteBookRequest);
        return new ResponseEntity<>(HttpStatus.ACCEPTED);
    }
}
