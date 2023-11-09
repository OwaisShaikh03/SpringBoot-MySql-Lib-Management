package com.ca2restapi.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.ca2restapi.model.Book;
import com.ca2restapi.service.BookService;



@RestController
@RequestMapping("/book") 

public class BookApiController {

    private final BookService bookService;

    public BookApiController(BookService bookService) {
        this.bookService = bookService;
    }

    
    @GetMapping("{bookId}")
    public Book getBookDetails(@PathVariable("bookId") Long bookId) {
        return bookService.getBook(bookId);
    }

    
    @GetMapping()
    public List<Book> getAllBookDetails() {
        return bookService.getAllBooks();
    }

    
    @PostMapping()
    public String createBook(@RequestBody Book book) {
        bookService.createBook(book);
        return "Book details successfully added";
    }

    
    @PutMapping("{bookId}")
    public ResponseEntity<Book> updateBook(@PathVariable("bookId") Long bookId, @RequestBody Book book) {
        return new ResponseEntity<>(bookService.updateBook(book, bookId), HttpStatus.OK);
    }

    
    @DeleteMapping("{bookId}")
    public String deleteBook(@PathVariable("bookId") Long bookId) {
        bookService.deleteBook(bookId);
        return "Book deleted successfully";
    }
}
