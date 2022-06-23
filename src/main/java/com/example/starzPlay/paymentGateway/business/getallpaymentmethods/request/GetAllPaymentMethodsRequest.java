package com.example.starzPlay.paymentGateway.business.getallpaymentmethods.request;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
@Builder
public class GetAllPaymentMethodsRequest {
    private String name;
    private BigDecimal id;
}
