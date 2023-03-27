package com.ll.gramgram_ai.base.rq;

import com.ll.gramgram_ai.boundedContext.member.entity.Member;
import com.ll.gramgram_ai.boundedContext.member.service.MemberService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.RequestScope;

@Component
@RequestScope
@Slf4j
public class Rq {
    private final HttpServletRequest req;
    private final HttpServletResponse resp;

    private final User user;
    @Getter
    private final Member member;
    private final MemberService memberService;

    public Rq(HttpServletRequest req, HttpServletResponse resp, MemberService memberService) {
        this.req = req;
        this.resp = resp;
        this.memberService = memberService;

        // 현재 로그인한 회원의 인증정보를 가져옴
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

        if (authentication.getPrincipal() instanceof User) {
            this.user = (User) authentication.getPrincipal();
            this.member = memberService.findByUsername(user.getUsername()).get();
        } else {
            this.user = null;
            this.member = null;
        }
    }

    public boolean isLogout() {
        return member == null;
    }

    public boolean isLogined() {
        return isLogout() == false;
    }
}
