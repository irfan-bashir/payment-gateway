package com.example.starzPlay.paymentGateway.utils;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum ValidationError {
    NAME_AND_ID_NOT_ACCEPTABLE("Both name and id are not acceptable.");
    private final String message;
}
