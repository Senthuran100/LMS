package com.senthuran.LMS.service;

import com.senthuran.LMS.repository.BookRepository;
import com.senthuran.LMS.repository.LibraryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LibraryService {
    @Autowired
    private LibraryRepository libraryRepository;

    @Autowired
    private BookRepository bookRepository;
    
}
