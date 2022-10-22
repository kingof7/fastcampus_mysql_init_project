package com.example.fastcampusmysql.domain.member.service;

import com.example.fastcampusmysql.domain.member.dto.RegisterMemberCommand;
import com.example.fastcampusmysql.domain.member.entity.Member;
import com.example.fastcampusmysql.domain.member.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class MemberWriteService {
    final private MemberRepository memberRepository; //주입받기 위해 @RequiredArgsConstructor 써줌

    public Member register(RegisterMemberCommand command) {
        /* 1. 목표 : 회원정보(이메일, 닉네임, 생년월일) 등록
                   - 닉네임은 10자를 넘을 수 없다.
        *  param : memberRegisterCommand
        *  val member = Member.of(memberRegisterCommand)
        *  memberRepository.save(member);
        * */
        Member member = Member.builder()
                              .nickname(command.getNickname())
                              .email(command.getEmail())
                              .birthday(command.getBirthday())
                              .build();

        return memberRepository.save(member);
    }

    public void changeNickname(Long memberId, String nickname) {
        /*
        * 1. 회원의 이름을 변경
        * 2. 변경 내역을 저장한다. ( 히스토리 )
        * */
        Member member = memberRepository.findById(memberId).orElseThrow();
        member.changeNickname(nickname);
        memberRepository.save(member);
        // TODO: 변경내역 히스토리를 저장한다.

    }
}
