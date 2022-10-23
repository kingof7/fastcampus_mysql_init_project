package com.example.fastcampusmysql.domain.member.service;

import com.example.fastcampusmysql.domain.member.entity.Follow;
import com.example.fastcampusmysql.domain.member.repository.FollowRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class FollowReadService {
    final private FollowRepository followRepository;
    public List<Follow> getFollowings(Long memberId) {
        return followRepository.findAllByFromMemberId(memberId);
    }
}
