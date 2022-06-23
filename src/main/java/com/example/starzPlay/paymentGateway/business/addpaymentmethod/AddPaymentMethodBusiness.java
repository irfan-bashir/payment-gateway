package com.example.starzPlay.paymentGateway.business.addpaymentmethod;

import com.example.starzPlay.paymentGateway.business.addpaymentmethod.request.AddPaymentMethodRequest;
import com.example.starzPlay.paymentGateway.business.addpaymentmethod.response.AddPaymentMethodResponse;
import com.example.starzPlay.paymentGateway.entities.PaymentMethod;
import com.example.starzPlay.paymentGateway.entities.PaymentPlan;
import com.example.starzPlay.paymentGateway.repositories.PaymentMethodRepository;
import com.example.starzPlay.paymentGateway.repositories.PaymentPlanRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;

import java.util.HashSet;
import java.util.Set;

@Component
@Slf4j
public class AddPaymentMethodBusiness {
    @Autowired
    private PaymentMethodRepository paymentMethodRepository;

    @Autowired
    private PaymentPlanRepository paymentPlanRepository;

    public AddPaymentMethodResponse execute(AddPaymentMethodRequest request){
        try {
            PaymentMethod paymentMethod = new PaymentMethod();
            paymentMethod.setDisplayName(request.getDisplayName());
            paymentMethod.setName(request.getName());
            paymentMethod.setPaymentType(request.getPaymentType());
            PaymentMethod savedPaymentMethod = paymentMethodRepository.save(paymentMethod);
            Set<PaymentPlan> paymentPlans = new HashSet<>();
            paymentPlans.addAll(request.getPaymentPlans());
            paymentPlans.forEach(paymentPlan -> paymentPlan.setPaymentMethod(savedPaymentMethod));
            savedPaymentMethod.setPaymentPlans(paymentPlans);
            paymentMethodRepository.saveAndFlush(savedPaymentMethod);
            return AddPaymentMethodResponse.builder().isSuccess(true).message("Success").status(HttpStatus.OK.value()).build();
        }catch (Exception e){
            e.printStackTrace();
            log.error(e.getMessage());
            return AddPaymentMethodResponse.builder().isSuccess(false).message("Failed").status(HttpStatus.INTERNAL_SERVER_ERROR.value()).build();
        }
    }
}
