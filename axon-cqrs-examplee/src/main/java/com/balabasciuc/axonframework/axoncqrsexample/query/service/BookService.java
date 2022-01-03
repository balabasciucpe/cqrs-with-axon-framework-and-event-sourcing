package com.balabasciuc.axonframework.axoncqrsexample.query.service;

import com.balabasciuc.axonframework.axoncqrsexample.common_to_both.BookActivedEvent;
import com.balabasciuc.axonframework.axoncqrsexample.common_to_both.BookCreatedEvent;
import com.balabasciuc.axonframework.axoncqrsexample.common_to_both.BookDeletedEvent;
import com.balabasciuc.axonframework.axoncqrsexample.common_to_both.BookRevisedEvent;
import com.balabasciuc.axonframework.axoncqrsexample.query.dto.FindBookByIdQuery;
import com.balabasciuc.axonframework.axoncqrsexample.query.dto.FindBookByTitleQuery;
import com.balabasciuc.axonframework.axoncqrsexample.query.model.Book;
import com.balabasciuc.axonframework.axoncqrsexample.query.repository.BookRepository;
import lombok.extern.slf4j.Slf4j;
import org.axonframework.eventhandling.EventHandler;
import org.axonframework.queryhandling.QueryHandler;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class BookService {

    private BookRepository bookRepository;

    public BookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    @EventHandler
    public void on(BookCreatedEvent evt) {
        log.info("Handling BookCreatedEvent... starting");
        Book book = new Book(evt.getId(), evt.getBookDetails(), "CREATED");
        bookRepository.save(book);
    }

    @EventHandler
    public void on(BookActivedEvent evt) {
        log.info("Handling BookActivatedEvent... starting");
        Book book = bookRepository.getById(evt.getId());
        book.setBookStatus("ACTIVATED");
        bookRepository.save(book);
    }

    @EventHandler
    public void on(BookRevisedEvent evt) {
        log.info("Handling BookRevisedEvent");
        Book book = new Book(); // bookRepository.getById(evt.getId());
        book.setBookId(evt.getId());
        book.setBookDetails(evt.getNewBookDetails());
        book.setBookStatus("REVISED");
        bookRepository.save(book);
    }

    @EventHandler
    public void on(BookDeletedEvent evt) {
        log.info("Handling BookDeletedEvent... Starting.");
        bookRepository.deleteById(evt.getId());
    }

    @QueryHandler
    public Book findBookById(FindBookByIdQuery query) {
        log.info("Handling FindBookByIdQuery... Starting");
        Book book = bookRepository.findById(query.getBookId()).orElseThrow();
        if (book != null) {
            return book;
        } else {
            throw new RuntimeException("nu exista");
        }
    }

    @QueryHandler
    public Book findBookByBookTitle(FindBookByTitleQuery query) {
        log.info("Handling FindBookByTitleQuery... Starting");
        Book book = bookRepository.findBookByBookDetails_BookTitle(query.getBookTitle());
        if (book != null) {
            return book;
        } else {
            throw new RuntimeException("not found");
        }
    }

}
