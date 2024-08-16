package com.example.library.dto;

import lombok.Data;

import java.time.LocalDateTime;
import java.util.Date;

@Data
public class AddMemberDTO {
    private String name;
    private final LocalDateTime membershipDate = LocalDateTime.now();
}
