package com.senthuran.LMS.controller;

import com.senthuran.LMS.exception.ResourceNotFoundException;
import com.senthuran.LMS.model.Book;
import com.senthuran.LMS.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/v1")
public class BookController {

    @Autowired
    BookService bookService;

    @PostMapping("/book")
    public ResponseEntity<Book> saveBook(@Valid @RequestBody Book bookRequest) {
        Book book = bookService.addBook(bookRequest);
        return new ResponseEntity<>(book, HttpStatus.OK);
    }

    @PutMapping("/book/{bookId}")
    public ResponseEntity<Book> updateBook(@PathVariable(value = "bookId") Integer bookId,
                                           @Valid @RequestBody Book bookRequest) throws ResourceNotFoundException {
        Book book = bookService.updateBook(bookId, bookRequest);
        return new ResponseEntity<>(book, HttpStatus.OK);
    }

    @GetMapping("/books")
    public ResponseEntity<List<Book>> getBooks() {
        return new ResponseEntity<>(bookService.getAllBooks(), HttpStatus.OK);
    }

    @DeleteMapping("/book/{bookId}")
    public ResponseEntity<?> deleteBook(@PathVariable(value = "bookId") Integer bookId) throws ResourceNotFoundException {
        return bookService.removeBook(bookId);
    }
}
