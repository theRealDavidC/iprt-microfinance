package com.iprt.microfinance.service;

import com.iprt.microfinance.model.Member;
import com.iprt.microfinance.repository.MemberRepository;
import java.util.List;
import java.util.Optional;

public class MemberService {

    private final MemberRepository memberRepository;

    public MemberService(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    public Member register(String fullName, String phone) {
        if (fullName == null || fullName.isBlank()) {
            throw new RuntimeException("Full name cannot be empty");
        }
        if (phone == null || phone.isBlank()) {
            throw new RuntimeException("Phone cannot be empty");
        }
        Member member = new Member(fullName, phone);
        memberRepository.save(member);
        return member;
    }

    public Optional<Member> findById(Long id) {
        return memberRepository.findById(id);
    }

    public List<Member> findAll() {
        return memberRepository.findAll();
    }
}
