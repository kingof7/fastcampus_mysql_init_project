package com.example.fastcampusmysql.domain.member.entity;

import lombok.Builder;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public class AbstractDto {
    private LocalDateTime createdAt;

    @Builder
    public AbstractDto(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }
}
