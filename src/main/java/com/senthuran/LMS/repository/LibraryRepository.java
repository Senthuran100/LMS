package com.senthuran.LMS.repository;

import com.senthuran.LMS.model.Library;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface LibraryRepository extends JpaRepository<Library, Integer> {

    List<Library> findByName(String name);
}
