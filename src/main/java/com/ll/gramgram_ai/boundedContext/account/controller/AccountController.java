package com.ll.gramgram_ai.boundedContext.account.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@Slf4j
@RequiredArgsConstructor
@RequestMapping("/account")
public class AccountController {
    @GetMapping("/login")
    public String showLogin() {
        return "usr/account/login";
    }
}
