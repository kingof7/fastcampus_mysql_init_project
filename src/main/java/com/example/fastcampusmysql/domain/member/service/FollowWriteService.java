package com.example.fastcampusmysql.domain.member.service;

import com.example.fastcampusmysql.domain.member.dto.MemberDto;
import com.example.fastcampusmysql.domain.member.entity.Follow;
import com.example.fastcampusmysql.domain.member.repository.FollowRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import java.util.Objects;

@RequiredArgsConstructor
@Service
public class FollowWriteService {
    final private FollowRepository followRepository;

    public void create(MemberDto fromMember, MemberDto toMember) {
        /*
        * 1. from, to 회원정보를 받아서
        * 저장
        * from <-> to validation ( 서로 다른 사람이므로 ) -> 식별자를 무엇으로 받을까? (존재하는 회원인지 검증을 여기서 해야함) -> MSA 구현이 어렵고 도메인 간 결합도가 강해질 수 있음
        * entity(dto)로 받는 것이 좋겠다.
        * */
        Assert.isTrue(!Objects.equals(fromMember.getId(), toMember.getId()), "From, To 회원이 동일합니다."); //Assert는 유효성 검증 class
        Follow follow = Follow.builder().fromMemberId(fromMember.getId())
                .toMemberId(toMember.getId())
                .build();
        followRepository.save(follow);
    }
}
