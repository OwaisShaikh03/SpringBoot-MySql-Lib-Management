package com.ca2restapi.service.implementaion; // Change the package name to match your project's package structure

import com.ca2restapi.BookRepository.BookRepository;
import com.ca2restapi.model.Book;
import com.ca2restapi.service.BookService;

import net.javaguides.springboot.exception.ResourceNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class BookServiceImplementation implements BookService {

    private final BookRepository bookRepository;

    public BookServiceImplementation(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    @Override
    public String createBook(Book book) {
        bookRepository.save(book);
        return "Data stored successfully";
    }

    @Override
    public Book updateBook(Book book, Long bookId) {
        Book existingBook = bookRepository.findById(bookId).orElseThrow(() -> new ResourceNotFoundException("Book", "bookId", bookId));
        existingBook.setBookName(book.getBookName());
        existingBook.setAuthorName(book.getAuthorName());
        existingBook.setPrice(book.getPrice());

        bookRepository.save(existingBook);
        return existingBook;
    }

    @Override
    public String deleteBook(Long bookId) {
        bookRepository.deleteById(bookId);
        return "success";
    }

    @Override
    public String deleteAllBooks() {
        bookRepository.deleteAll();
        return "success";
    }

    @Override
    public Book getBook(Long bookId) {
        return bookRepository.findById(bookId).orElseThrow(
                () -> new ResourceNotFoundException("Book", "bookId", bookId));
    }

    @Override
    public List<Book> getAllBooks() {
        return bookRepository.findAll();
    }
}
