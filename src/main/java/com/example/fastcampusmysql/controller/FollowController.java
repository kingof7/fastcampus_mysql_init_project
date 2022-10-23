package com.example.fastcampusmysql.controller;

import com.example.fastcampusmysql.application.usecase.CreateFollowMemberUseCase;
import com.example.fastcampusmysql.application.usecase.GetFollowingMemberUsecase;
import com.example.fastcampusmysql.domain.member.dto.MemberDto;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/follow")
public class FollowController {
    final private CreateFollowMemberUseCase createFollowMemberUseCase;
    final private GetFollowingMemberUsecase getFollowingMemberUsecase;

    @PostMapping("/{fromId}/{toId}")
    public void create(@PathVariable Long fromId, @PathVariable Long toId) {
        createFollowMemberUseCase.execute(fromId, toId);
    }

    @GetMapping("/members/{fromId}")
    public List<MemberDto> getFollowings(@PathVariable Long fromId) {
        return getFollowingMemberUsecase.execute(fromId);
    }
}
