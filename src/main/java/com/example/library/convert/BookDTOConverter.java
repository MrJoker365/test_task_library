package com.example.library.convert;

import com.example.library.dto.AddBookDTO;
import com.example.library.model.Books;
import org.modelmapper.Conditions;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class BookDTOConverter {

    private final ModelMapper modelMapper;

    @Autowired
    public BookDTOConverter(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }


    public Books convertAddBookDTOToBooks(AddBookDTO addBookDTO){
        Books books = modelMapper.map(addBookDTO, Books.class);
        books.setAmount(1);

        return books;
    }

//    public Books convertAddBookDTOToBooks(AddBookDTO addBookDTO, Books books){
//        System.out.println(addBookDTO);
//        System.out.println(books);
//        ModelMapper modelMapper = new ModelMapper();
//        modelMapper.getConfiguration().setPropertyCondition(Conditions.isNotNull());
//        modelMapper.map(addBookDTO, books);
//
//        return books;
//    }



}
