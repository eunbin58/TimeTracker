package com.project.timetracker.common.exception;

public class EmailAlreadyExistsException
        extends RuntimeException {

    public EmailAlreadyExistsException(String message) {
        //super: 부모 클래스
        //부모 클래스에 message를 넘겨야 다른곳에서 exception.getMessage() 사용가능
        super(message);
    }
}