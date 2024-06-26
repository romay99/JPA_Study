package com.jpa.demo.service;

import com.jpa.demo.domain.Member;
import com.jpa.demo.repository.MemberRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.transaction.annotation.Transactional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@Transactional
@ExtendWith(SpringExtension.class)
class MemberServiceTest {
    @Autowired private MemberService memberService;
    @Autowired private MemberRepository memberRepository;

    @Test
    public void 회원가입() throws Exception {
        //given
        Member member = new Member();
        member.setName("라절자ㅣㄹ");

        //when
        Long memberId = memberService.joinMember(member);

        //then
        assertEquals(member,memberRepository.findById(memberId));
    }

    @Test
    public void 중복회원검사() throws Exception {
        //given
        Member member1 = new Member();
        member1.setName("뷔");

        Member member2 = new Member();
        member2.setName("뷔");

        //when
        memberService.joinMember(member1);

        //then
        assertThrows(IllegalStateException.class , ()-> memberService.joinMember(member2));
    }

}