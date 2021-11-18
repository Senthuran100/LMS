package com.senthuran.LMS.service;

import com.senthuran.LMS.exception.ResourceNotFoundException;
import com.senthuran.LMS.model.Book;
import com.senthuran.LMS.model.Library;
import com.senthuran.LMS.repository.BookRepository;
import com.senthuran.LMS.repository.LibraryRepository;
import org.springframework.beans.factory.annotation.Autowired;
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
        Library library = libraryRepository.findById(book.getLibrary().getId()).orElse(null);
        if (null == library) {
            library = new Library();
        }
        library.setName(book.getLibrary().getName());
        book.setLibrary(library);
        return bookRepository.save(book);
    }

    public Book updateBook(Integer bookId, Book bookRequest) throws ResourceNotFoundException {
        if (!libraryRepository.existsById(bookRequest.getLibrary().getId())) {
            throw new ResourceNotFoundException("Library Id Not Found" + bookId);
        }
        return bookRepository.findById(bookId).map(book -> {
            book.setName(bookRequest.getName());
            book.setDescription(book.getDescription());
            return bookRepository.save(book);
        }).orElseThrow(() -> new ResourceNotFoundException("Book Id Not Found" + bookId));
    }
}
