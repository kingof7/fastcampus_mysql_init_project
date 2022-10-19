package com.example.fastcampusmysql.domain.member.repository;

import com.example.fastcampusmysql.domain.member.entity.Member;
import lombok.RequiredArgsConstructor;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Repository;

@RequiredArgsConstructor
@Repository
public class MemberRepository {
    final private NamedParameterJdbcTemplate namedParameterJdbcTemplate;
    public Member save(Member member) {
        /*
        * member id를 보고 갱신 또는 삽입 결정
        * 반환값은 id를 읽어서 반환한다.
        * */
        //return Member.builder().build();
        if (member.getId() == null) {
            return insert(member);
        }
        return update(member);
    }

    private Member insert(Member member) {
        SimpleJdbcInsert simpleJdbcInsert = new SimpleJdbcInsert(namedParameterJdbcTemplate.getJdbcTemplate())
                .withTableName("Member")
                .usingGeneratedKeyColumns("id") // 가져올 키 (key holidng)
                ;
        SqlParameterSource params = new BeanPropertySqlParameterSource(member); //POJO 넣어줌 (member)
        long id = simpleJdbcInsert.executeAndReturnKey(params).longValue(); // insert 후 받은 키
        return Member.builder()
                .id(id)
                .email(member.getEmail())
                .nickname(member.getNickname())
                .birthDay(member.getBirthDay())
                .createdAt(member.getCreatedAt())
                .build();
    }

    private Member update(Member member) {
        // TODO : implemented
        return member;
    }
}
