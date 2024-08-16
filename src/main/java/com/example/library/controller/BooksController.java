package com.example.library.controller;

import com.example.library.dto.AddBookDTO;
import com.example.library.model.Books;
import com.example.library.service.impl.BooksServiceImpl;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/books")
@RequiredArgsConstructor
@Validated
@Data
public class BooksController {

    private final BooksServiceImpl booksService;


    @PostMapping
    public ResponseEntity<?> addBook(@Validated @RequestBody AddBookDTO addBookDTO) {

        System.out.println("ПЕРЕВІРКА");
        System.out.println(addBookDTO);

        Books books = booksService.addBook(addBookDTO);

        System.out.println("ПЕРЕВІРКА");
        System.out.println(books);

        return new ResponseEntity<>(books, HttpStatus.OK);
    }

}
