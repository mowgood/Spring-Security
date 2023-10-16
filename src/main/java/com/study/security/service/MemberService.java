package com.study.security.service;

import com.study.security.domain.Member;
import com.study.security.dto.request.MemberCreateRequestDto;
import com.study.security.exception.EmailDuplicatedException;
import com.study.security.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MemberService {

    private final MemberRepository memberRepository;
    private final PasswordEncoder passwordEncoder;

    public void signup(MemberCreateRequestDto requestDto) {
        if (memberRepository.existsByEmail(requestDto.getEmail())) {
            throw new EmailDuplicatedException();
        }

        String encryptedPassword = passwordEncoder.encode(requestDto.getPassword());

        var member = Member.builder()
                .name(requestDto.getName())
                .email(requestDto.getEmail())
                .password(encryptedPassword)
                .build();

        memberRepository.save(member);
    }

}
