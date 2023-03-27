package com.ll.gramgram_ai.boundedContext.account.service;

import com.ll.gramgram_ai.boundedContext.member.service.MemberService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@Slf4j
@RequiredArgsConstructor
public class AccountService {
    private final PasswordEncoder passwordEncoder;
    private final MemberService memberService;

    public void join(String username, String password) {
        memberService.create(username, passwordEncoder.encode(password));
    }
}
