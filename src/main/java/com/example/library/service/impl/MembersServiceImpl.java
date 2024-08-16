package com.example.library.service.impl;

import com.example.library.convert.MemberDTOConverter;
import com.example.library.dto.AddMemberDTO;
import com.example.library.dto.BorrowBookDTO;
import com.example.library.model.Books;
import com.example.library.model.Members;
import com.example.library.repo.BooksRepo;
import com.example.library.repo.MembersRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor(onConstructor_ = {@Autowired})
public class MembersServiceImpl {

    private final MembersRepo membersRepo;
    private final BooksRepo booksRepo;

    private final MemberDTOConverter memberDTOConverter;




    public Members addMember (AddMemberDTO addMemberDTO) {

        return membersRepo.save(memberDTOConverter.convertAddMemberDTOToMembers(addMemberDTO));
    }




    public Boolean borrowBook (BorrowBookDTO borrowBookDTO) {

        Books books = booksRepo.findByTitleAndAuthor(
                borrowBookDTO.getTitle(),
                borrowBookDTO.getAuthor()
        ).orElse(new Books());

        Members members = membersRepo.findByName(borrowBookDTO.getMembersName()).orElse(new Members());

        if (books.getTitle() == null || books.getAmount() == 0) {
            System.out.println("Такої книжки не існує");
            return false;
        }else if (members.getId() == 0) {
            System.out.println("Такого читача не існує");
            return false;
        }else {
            List<Members> m = books.getMembers();
            m.add(members);

            books.setAmount(books.getAmount() - 1);
            books.setMembers(m);

            System.out.println(booksRepo.save(books));

            return true;
        }

    }


}
