package com.ll.gramgram_ai.boundedContext.home.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@Slf4j
@RequiredArgsConstructor
@RequestMapping("/")
public class HomeController {
    @GetMapping("")
    public String showMain() {
        return "usr/home/main";
    }
}
