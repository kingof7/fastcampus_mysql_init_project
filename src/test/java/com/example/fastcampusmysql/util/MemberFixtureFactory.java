package com.example.fastcampusmysql.util;

import com.example.fastcampusmysql.domain.member.entity.Member;
import org.jeasy.random.EasyRandom;
import org.jeasy.random.EasyRandomParameters;

public class MemberFixtureFactory {
    //EasyRandom > test에서 객체를 만들어주는 라이브러리
    static public Member create() {
        EasyRandomParameters param = new EasyRandomParameters();
        return new EasyRandom(param).nextObject(Member.class);
    }
    static public Member create(Long seed) {
        //EasyRandom은 seed 기반으로 동작
        EasyRandomParameters param = new EasyRandomParameters().seed(seed);
        return new EasyRandom(param).nextObject(Member.class);
    }
}
