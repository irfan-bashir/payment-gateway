package com.example.starzPlay.paymentGateway.business.updatepaymentmethod.response;

import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UpdatePaymentMethodResponse {
    private int status;
    private String message;
    private Boolean isSuccess;
}
