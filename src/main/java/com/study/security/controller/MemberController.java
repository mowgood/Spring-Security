package com.study.security.controller;

import com.study.security.dto.request.MemberCreateRequestDto;
import com.study.security.service.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class MemberController {

    private final MemberService memberService;

    @GetMapping("/login")
    public String login() {
        return "로그인 페이지";
    }

    @PostMapping("/signup")
    public void signup(@RequestBody MemberCreateRequestDto requestDto) {
        memberService.signup(requestDto);
    }
}
