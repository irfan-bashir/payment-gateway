package com.example.starzPlay.paymentGateway.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

@Component
public class BaseController {

    @Autowired
    private MessageSource messageSource;

    public <T> ResponseEntity<T> successResponse(T data, HttpStatus httpStatus) {
        return new ResponseEntity<>(data, httpStatus);
    }

}
