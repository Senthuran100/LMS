package com.senthuran.LMS.controller;

import com.senthuran.LMS.exception.ResourceNotFoundException;
import com.senthuran.LMS.model.Library;
import com.senthuran.LMS.service.LibraryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
public class LibraryController {

    @Autowired
    private LibraryService libraryService;

    @GetMapping("/libraries")
    public ResponseEntity<List<Library>> getLibraries() {
        return new ResponseEntity<>(libraryService.getAllLibraries(), HttpStatus.OK);
    }

    @PostMapping("/library")
    public ResponseEntity<Library> addLibrary(@RequestBody Library libraryReq) {
        Library library = libraryService.addLibrary(libraryReq);
        return new ResponseEntity<>(library, HttpStatus.OK);
    }

    @PutMapping("/library/{libraryId}")
    public ResponseEntity<Library> updateLibrary(@PathVariable(value = "libraryId") Integer libraryId, @RequestBody Library libraryReq) throws ResourceNotFoundException {
        Library library = libraryService.updateLibrary(libraryId, libraryReq);
        return new ResponseEntity<>(library, HttpStatus.OK);
    }

    @DeleteMapping("/library/{libraryId}")
    public ResponseEntity<?> deleteLibrary(@PathVariable(value = "libraryId") Integer libraryId) throws ResourceNotFoundException {
        return new ResponseEntity<>(libraryService.removeLibrary(libraryId), HttpStatus.OK);
    }

}
