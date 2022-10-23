package com.example.fastcampusmysql.domain.member.dto;

import lombok.Builder;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public class MemberNicknameHistoryDto {
    private Long id;
    private Long memberId;
    private String nickname;
    private LocalDateTime createdAt;

    @Builder
    public MemberNicknameHistoryDto(Long id, Long memberId, String nickname, LocalDateTime createdAt) {
        this.id = id;
        this.memberId = memberId;
        this.nickname = nickname;
        this.createdAt = createdAt;
    }
}
