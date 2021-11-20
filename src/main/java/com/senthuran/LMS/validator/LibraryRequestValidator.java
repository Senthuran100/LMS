package com.senthuran.LMS.validator;

import com.senthuran.LMS.exception.RecordFoundException;
import com.senthuran.LMS.model.Library;
import com.senthuran.LMS.repository.LibraryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class LibraryRequestValidator {

    @Autowired
    LibraryRepository libraryRepository;

    public boolean validateLibraryCreateRequest(Library library) throws RecordFoundException {
        List<Library> result = libraryRepository.findByName(library.getName());
        if (result.isEmpty()) {
            return true;
        } else {
            throw new RecordFoundException("Library Name already Found " + library.getName());
        }
    }

}
