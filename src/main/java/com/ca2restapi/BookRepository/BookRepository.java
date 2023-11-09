package com.ca2restapi.BookRepository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.ca2restapi.model.Book;

import java.util.List;

public interface BookRepository extends JpaRepository<Book, Long> { 

    @Query(value = "SELECT * FROM book", nativeQuery = true)
    List<Book> getAllBooks(); 

    
}
