package com.example.library.convert;

import com.example.library.dto.AddBookDTO;
import com.example.library.dto.AddMemberDTO;
import com.example.library.model.Books;
import com.example.library.model.Members;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class MemberDTOConverter {

    @Autowired
    private ModelMapper modelMapper;


    public Members convertAddMemberDTOToMembers(AddMemberDTO addMemberDTO){
        Members members = modelMapper.map(addMemberDTO, Members.class);
        return members;
    }


}
