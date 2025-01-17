package com.example.library.repo;

import com.example.library.model.Books;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface BooksRepo extends JpaRepository<Books, Long> {

    Optional<Books> findByTitleAndAuthor(String title, String author);

}
