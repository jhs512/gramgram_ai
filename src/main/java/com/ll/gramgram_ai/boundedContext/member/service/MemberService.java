package com.ll.gramgram_ai.boundedContext.member.service;

import com.ll.gramgram_ai.boundedContext.member.entity.Member;
import com.ll.gramgram_ai.boundedContext.member.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@Slf4j
@RequiredArgsConstructor
public class MemberService {
    private final MemberRepository memberRepository;

    public Member create(String username, String password) {
        Member member = Member
                .builder()
                .accountProviderTypeCode("gramgram")
                .username(username)
                .password(password)
                .build();

        return memberRepository.save(member);
    }

    public Optional<Member> findByUsername(String username) {
        return memberRepository.findByUsername(username);
    }

    public Member createWithSocialLogin(String accountProviderTypeCode, String username) {
        Member member = Member
                .builder()
                .accountProviderTypeCode(accountProviderTypeCode)
                .username(username)
                .build();

        return memberRepository.save(member);
    }
}
