package com.study.security.exception;

import org.springframework.http.HttpStatus;

public class EmailDuplicatedException extends GlobalException {

    private static final String MESSAGE = "중복된 이메일 입니다.";

    public EmailDuplicatedException() {
        super(MESSAGE);
    }

    @Override
    public int getStatusCode() {
        return HttpStatus.NOT_FOUND.value();
    }
}
