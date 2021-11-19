package com.senthuran.LMS.service;

import com.senthuran.LMS.exception.ResourceNotFoundException;
import com.senthuran.LMS.model.Book;
import com.senthuran.LMS.repository.BookRepository;
import com.senthuran.LMS.repository.LibraryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookService {

    @Autowired
    private LibraryRepository libraryRepository;

    @Autowired
    private BookRepository bookRepository;

    public List<Book> getAllBooks() {
        return bookRepository.findAll();
    }

    public Book addBook(Book book) {
        return bookRepository.save(book);
    }

    public Book updateBook(Integer bookId, Book bookRequest) throws ResourceNotFoundException {
        return bookRepository.findById(bookId).map(book -> {
            book.setName(bookRequest.getName());
            book.setDescription(bookRequest.getDescription());
            return bookRepository.save(book);
        }).orElseThrow(() -> new ResourceNotFoundException("Book Id Not Found " + bookId));
    }

    public ResponseEntity<?> removeBook(Integer bookId) throws ResourceNotFoundException {
        return bookRepository.findById(bookId).map(book -> {
            bookRepository.delete(book);
            return ResponseEntity.ok().build();
        }).orElseThrow(() -> new ResourceNotFoundException("Book Id Not Found " + bookId));
    }
}
