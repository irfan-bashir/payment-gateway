package com.example.starzPlay.paymentGateway.operational;

public interface Validator<AREQ> {

    void validate(AREQ input);
}
