package com.example.starzPlay.paymentGateway.business.addpaymentmethod.request;


import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class AddPaymentPlan {
    private String netAmount;
    private String taxAmount;
    private String description;
    private String currency;
    private String duration;
}
