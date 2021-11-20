package com.senthuran.LMS.service;

import com.senthuran.LMS.exception.ResourceNotFoundException;
import com.senthuran.LMS.model.Library;
import com.senthuran.LMS.repository.BookRepository;
import com.senthuran.LMS.repository.LibraryRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Slf4j
@Service
public class LibraryService {
    @Autowired
    private LibraryRepository libraryRepository;

    @Autowired
    private BookRepository bookRepository;

    public List<Library> getAllLibraries() {
        return libraryRepository.findAll();
    }

    @Transactional
    public Library addLibrary(Library libraryReq) {
        return libraryRepository.save(libraryReq);
    }

    public Library updateLibrary(Integer libraryId, Library libraryReq) throws ResourceNotFoundException {
        return libraryRepository.findById(libraryId).map(library -> {
            library.setName(libraryReq.getName());
            library.setBooks(libraryReq.getBooks());
            return libraryRepository.save(library);
        }).orElseThrow(() -> new ResourceNotFoundException("Library Id Not Found " + libraryId));
    }

    public ResponseEntity<?> removeLibrary(Integer libraryId) throws ResourceNotFoundException {
        return libraryRepository.findById(libraryId).map(library -> {
            libraryRepository.delete(library);
            return ResponseEntity.ok().build();
        }).orElseThrow(() -> new ResourceNotFoundException("Book Id Not Found " + libraryId));
    }
}
