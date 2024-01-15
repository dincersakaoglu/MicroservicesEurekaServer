package com.dangercodex.libraryservice.repository;

import com.dangercodex.libraryservice.model.Library;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LibraryRepository extends JpaRepository<Library, String> {
} 
