package com.senthuran.LMS;

import com.senthuran.LMS.model.Book;
import com.senthuran.LMS.model.Library;
import com.senthuran.LMS.repository.BookRepository;
import com.senthuran.LMS.repository.LibraryRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
@EnableJpaAuditing
public class LmsApplication {


    public static void main(String[] args) {
        SpringApplication.run(LmsApplication.class, args);
    }

    @Bean
    public CommandLineRunner mappingDemo(BookRepository bookRepository, LibraryRepository libraryRepository) {
        return args -> {

            // create a new book
            Book book = new Book(1, "Book1", "Sample Book");

            // save the book
            bookRepository.save(book);


            List<Book> books = new ArrayList<>();
            books.add(book);
            Library library = new Library(1, "Library1", books);

            // save the library
            libraryRepository.save(library);
        };
    }

}
