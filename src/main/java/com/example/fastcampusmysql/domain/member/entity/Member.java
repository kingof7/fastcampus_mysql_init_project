package com.example.fastcampusmysql.domain.member.entity;

import lombok.*;
import org.springframework.util.Assert;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Objects;

@Getter
public class Member {
    final private Long id;
    private String nickname;
    final private String email;
    final private LocalDate birthDay;
    final private LocalDateTime createdAt;

    final private static Long NAME_MAX_LENGTH = 10L;

    @Builder
    public Member(Long id, String nickname, String email, LocalDate birthDay, LocalDateTime createdAt) {
        this.id = id;
        this.email = Objects.requireNonNull(email);
        this.birthDay = Objects.requireNonNull(birthDay);
        validateNickName(nickname);
        this.nickname = Objects.requireNonNull(nickname);
        this.createdAt = createdAt == null ? LocalDateTime.now() : createdAt;
    }

    void validateNickName(String nickname) {
        Assert.isTrue(nickname.length() <= NAME_MAX_LENGTH, "최대 길이를 초과하였습니다.");

    }
}
