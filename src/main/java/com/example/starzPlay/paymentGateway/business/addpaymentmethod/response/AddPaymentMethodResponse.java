package com.example.starzPlay.paymentGateway.business.addpaymentmethod.response;

import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class AddPaymentMethodResponse {

    private int status;
    private String message;
    private Boolean isSuccess;
}
