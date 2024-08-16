package com.example.library.controller;

import com.example.library.dto.AddBookDTO;
import com.example.library.dto.AddMemberDTO;
import com.example.library.dto.BorrowBookDTO;
import com.example.library.model.Books;
import com.example.library.model.Members;
import com.example.library.service.impl.MembersServiceImpl;
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
@RequestMapping("/api/members")
@RequiredArgsConstructor
@Validated
@Data
public class MembersController {

    private final MembersServiceImpl membersService;



    @PostMapping
    public ResponseEntity<?> addMember(@Validated @RequestBody AddMemberDTO addMemberDTO) {

        Members members = membersService.addMember(addMemberDTO);

        return new ResponseEntity<>(members, HttpStatus.OK);
    }


    @PostMapping("/borrow_book")
    public ResponseEntity<?> borrowBook(@Validated @RequestBody BorrowBookDTO borrowBookDTO) {

        Boolean result = membersService.borrowBook(borrowBookDTO);

        return new ResponseEntity<>(result, HttpStatus.OK);
    }

}
