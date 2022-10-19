package com.example.fastcampusmysql.domain.member.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class RegisterMemberCommand {
    public String email;
    public String nickname;
    public LocalDate birthday;

}
