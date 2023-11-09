package com.ca2restapi.service; 

import java.util.List;

import com.ca2restapi.model.Book;

public interface BookService {

    String createBook(Book book); 

    Book updateBook(Book book, Long bookId); 

    String deleteBook(Long bookId); 

    Book getBook(Long bookId); 

    List<Book> getAllBooks(); 

    String deleteAllBooks(); 
}
