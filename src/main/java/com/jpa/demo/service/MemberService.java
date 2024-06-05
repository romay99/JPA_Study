package com.jpa.demo.service;

import com.jpa.demo.domain.Member;
import com.jpa.demo.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class MemberService {

    private final MemberRepository memberRepository;

    @Transactional(readOnly = true)
    public Long joinMember(Member member) {
        validateDuplicdateMember(member);
        memberRepository.save(member);
        return member.getId();
    }

    private void validateDuplicdateMember(Member member) {
        List<Member> findMembers = memberRepository.findAllByName(member.getName());
        if (!findMembers.isEmpty()) {
            throw new IllegalStateException("이미 존재하는 회원 이름입니다.");
        }
    }

    @Transactional(readOnly = true)
    public List<Member> findMembers(){
        return memberRepository.findAll();
    }

    @Transactional(readOnly = true)
    public Member findMemberById(Long id) {
        return memberRepository.findById(id);
    }
}
