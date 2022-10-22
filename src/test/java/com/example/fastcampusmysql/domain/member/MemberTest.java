package com.example.fastcampusmysql.domain.member;

import com.example.fastcampusmysql.domain.member.entity.Member;
import com.example.fastcampusmysql.util.MemberFixtureFactory;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.stream.IntStream;
import java.util.stream.LongStream;

public class MemberTest {

    // objectMother pattern
    // class의 종류, 테스트를할때 사용
    // 생성을 도와준다. exmaple object
    @DisplayName("회원은 닉네임을 변경할 수 있다.")
    @Test
    public void testChangeName() {
//        LongStream.range(0, 10)
//                .mapToObj(MemberFixtureFactory::create)
//                .forEach(member -> {
//                    System.out.println(member.getNickname());
//                });
        Member member = MemberFixtureFactory.create();
        String expected = "pnu";
        member.changeNickname(expected);
        Assertions.assertEquals(expected, member.getNickname());
    }

    @DisplayName("회원은 닉네임은 10자를 초과할 수 없다.")
    @Test
    public void testNicknameMaxLength() {
//        LongStream.range(0, 10)
//                .mapToObj(MemberFixtureFactory::create)
//                .forEach(member -> {
//                    System.out.println(member.getNickname());
//                });
        Member member = MemberFixtureFactory.create();
        String overMaxLengthName = "pnupnupnupnu";
        Assertions.assertThrows(
                  IllegalArgumentException.class,
                  ()-> member.changeNickname(overMaxLengthName));
    }

}
