package com.balabasciuc.axonframework.axoncqrsexample.query.repository;

import com.balabasciuc.axonframework.axoncqrsexample.query.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookRepository extends JpaRepository<Book, String> {

    Book findBookByBookDetails_BookTitle(String bookTitle);


}
