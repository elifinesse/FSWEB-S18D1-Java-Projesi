package com.workintech.burgershop.exceptions;

import org.springframework.http.HttpStatus;

import lombok.Getter;

@Getter
public class BurgerException extends RuntimeException{

    private HttpStatus httpStatus;

    public BurgerException(String message, HttpStatus httpStatus){
        super(message);
        this.httpStatus = httpStatus;
    }
}
