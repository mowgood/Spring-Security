package com.study.security.dto.request;

import lombok.Builder;
import lombok.Getter;

@Getter
public class MemberCreateRequestDto {

    private String name;

    private String email;

    private String password;

    @Builder
    public MemberCreateRequestDto(String name, String email, String password) {
        this.name = name;
        this.email = email;
        this.password = password;
    }
}
