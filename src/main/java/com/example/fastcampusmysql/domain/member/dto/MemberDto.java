package com.example.fastcampusmysql.domain.member.dto;

import lombok.Builder;
import lombok.Getter;

import java.time.LocalDate;

@Getter
public class MemberDto {
    private Long id;
    private String email;
    private String nickname;
    private LocalDate birthday;

    @Builder
    public MemberDto(Long id, String email, String nickname, LocalDate birthday) {
        this.id = id;
        this.email = email;
        this.nickname = nickname;
        this.birthday = birthday;
    }
}
