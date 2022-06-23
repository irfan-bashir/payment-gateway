
package com.example.starzPlay.paymentGateway.services;


import com.example.starzPlay.paymentGateway.business.updatepaymentmethod.response.UpdatePaymentMethodResponse;
import com.example.starzPlay.paymentGateway.entities.PaymentMethod;

import java.math.BigDecimal;

public interface PaymentMethodService {
    public UpdatePaymentMethodResponse business(BigDecimal id, PaymentMethod paymentMethod);
}
