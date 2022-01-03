package com.balabasciuc.axonframework.axoncqrsexample.query.controller;


import com.balabasciuc.axonframework.axoncqrsexample.query.dto.FindBookByIdQuery;
import com.balabasciuc.axonframework.axoncqrsexample.query.dto.FindBookByTitleQuery;
import com.balabasciuc.axonframework.axoncqrsexample.query.model.Book;
import org.axonframework.queryhandling.QueryGateway;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/query-books")
public class BookQueryController {

    //axon Specific, asa trimitem querys
    private final QueryGateway queryGateway;

    public BookQueryController(QueryGateway queryGateway) {
        this.queryGateway = queryGateway;
    }

    @GetMapping(value = "/id")
    public ResponseEntity<Book> findBookById(@RequestParam String id) {
        Book book = queryGateway.query(new FindBookByIdQuery(id), Book.class).join();

        if (book != null) {
            return new ResponseEntity<>(book, HttpStatus.ACCEPTED);
        } else {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
    }

    @GetMapping(value = "/bookTitle")
    public ResponseEntity<Book> findBookByTitle(@RequestParam String bookTitle) {
        Book book = queryGateway.query(new FindBookByTitleQuery(bookTitle), Book.class).join();
        if (book != null) {
            return new ResponseEntity<>(book, HttpStatus.ACCEPTED);
        } else {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }

    }
}
