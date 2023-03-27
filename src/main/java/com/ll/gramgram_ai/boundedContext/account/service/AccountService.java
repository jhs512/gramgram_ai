package com.ll.gramgram_ai.boundedContext.account.service;

import com.ll.gramgram_ai.boundedContext.member.entity.Member;
import com.ll.gramgram_ai.boundedContext.member.service.MemberService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Slf4j
@RequiredArgsConstructor
@Transactional(readOnly = false)
public class AccountService {
    private final PasswordEncoder passwordEncoder;
    private final MemberService memberService;

    public Member join(String username, String password) {
        return memberService.create(username, passwordEncoder.encode(password));
    }

    public Member whenSocialLogin(String accountProviderTypeCode, String username) {
        Member member = memberService.findByUsername(username).orElse(null);

        if (member == null) {
            member = memberService.createWithSocialLogin(accountProviderTypeCode, username);
        }

        return member;
    }
}
