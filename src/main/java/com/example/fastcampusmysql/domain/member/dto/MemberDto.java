package com.example.fastcampusmysql.domain.member.dto;

import lombok.Builder;
import lombok.Getter;
import org.springframework.util.Assert;

import java.time.LocalDate;
import java.util.Objects;

@Getter
public class MemberDto {
    private Long id;
    private String email;
    private String nickname;
    private LocalDate birthday;
    final private static Long NAME_MAX_LENGTH = 10L;
    @Builder
    public MemberDto(Long id, String email, String nickname, LocalDate birthday) {
        this.id = id;
        this.email = email;
        this.nickname = nickname;
        this.birthday = birthday;
    }
    private void validateNickname(String nickname) {
        Assert.isTrue(nickname.length() <= NAME_MAX_LENGTH, "최대 길이를 초과했습니다.");
    }
}
