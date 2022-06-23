package com.example.starzPlay.paymentGateway.business.addpaymentmethod.request;

import com.example.starzPlay.paymentGateway.entities.PaymentPlan;
import lombok.*;

import java.util.Collection;
import java.util.Set;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class AddPaymentMethodRequest {
    private String name;
    private String displayName;
    private String paymentType;
    private Set<PaymentPlan> paymentPlans;
}
