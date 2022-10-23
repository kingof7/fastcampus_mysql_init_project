package com.example.fastcampusmysql.domain.member.entity;

import lombok.Builder;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public class Follow { // 팔로우 주체, 받은 회원 2명이 필요, Member 테이블과의 조인을 고려할만 하나, 강결합이 되므로 별로 좋지 않다. > 추후에 다른 성능문제가 있을 수 있다. (조인쿼리는 무겁기 떄문)
    // 초기에는 쿼리를 한번 더써서, 결합을 낮추는 것이 현명
    final private Long id;
    final private Long fromMemberId;
    final private Long toMemberId;
    final private LocalDateTime createdAt;

    @Builder
    public Follow(Long id, Long fromMemberId, Long toMemberId, LocalDateTime createdAt) {
        this.id = id;
        this.fromMemberId = fromMemberId;
        this.toMemberId = toMemberId;
        this.createdAt = createdAt == null ? LocalDateTime.now() : createdAt; // >> 추후에 추상화(추상 dto)를 통해서 중복을 제거하는 것이 좋음
    }
}
