package com.example.library.service.impl;

import com.example.library.convert.BookDTOConverter;
import com.example.library.dto.AddBookDTO;
import com.example.library.model.Books;
import com.example.library.repo.BooksRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor(onConstructor_ = {@Autowired})
public class BooksServiceImpl {

    private final BooksRepo booksRepo;

    private final BookDTOConverter bookDTOConverter;




    public Books addBook(AddBookDTO addBookDTO) {

        Books books = booksRepo.findByTitleAndAuthor(addBookDTO.getTitle(), addBookDTO.getAuthor()).orElse(new Books());

        if (books.getTitle() == null || books.getAuthor() == null) {
            books = bookDTOConverter.convertAddBookDTOToBooks(addBookDTO);
        }else {
            books.setAmount(books.getAmount() + 1);
        }

        return booksRepo.save(books);
    }

}
