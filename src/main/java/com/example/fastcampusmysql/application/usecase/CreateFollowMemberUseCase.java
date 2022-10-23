package com.example.fastcampusmysql.application.usecase;

import com.example.fastcampusmysql.domain.member.dto.MemberDto;
import com.example.fastcampusmysql.domain.member.service.FollowWriteService;
import com.example.fastcampusmysql.domain.member.service.MemberReadService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class CreateFollowMemberUseCase {
    final private MemberReadService memberReadService;
    final private FollowWriteService followWriteService;

    public void execute(Long fromMemberId, Long toMemberId) {
        /*
        * Orchestration (도메인(entity) 서비스의 흐름 제어)
        * 1. 입력받은 멤버아이디로 회원조회
        * 2. 팔로우라이트서비스.create()
        * */
        MemberDto fromMember = memberReadService.getMember(fromMemberId);
        MemberDto toMember = memberReadService.getMember(toMemberId);
        followWriteService.create(fromMember, toMember);
    }
}
