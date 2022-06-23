package com.example.starzPlay.paymentGateway.services.impl;


import com.example.starzPlay.paymentGateway.business.updatepaymentmethod.response.UpdatePaymentMethodResponse;
import com.example.starzPlay.paymentGateway.entities.PaymentMethod;
import com.example.starzPlay.paymentGateway.entities.PaymentPlan;
import com.example.starzPlay.paymentGateway.repositories.PaymentMethodRepository;
import com.example.starzPlay.paymentGateway.services.PaymentMethodService;
import com.example.starzPlay.paymentGateway.utils.NullAwareBeanUtilsBean;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.beanutils.BeanUtilsBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.lang.reflect.InvocationTargetException;
import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Optional;
import java.util.Set;


@Service
@Slf4j
public class PaymentMethodServiceImpl implements PaymentMethodService {

    @Autowired
    PaymentMethodRepository repository;

    @Override
    public UpdatePaymentMethodResponse business(BigDecimal id, PaymentMethod paymentMethod) {
        try {
            Optional<PaymentMethod> paymentMethodMaybe = repository.findById(id);
            if (paymentMethodMaybe.isPresent()){
                PaymentMethod savedPaymentMethod = paymentMethodMaybe.get();
                Set<PaymentPlan> paymentPlans = new HashSet<>(paymentMethod.getPaymentPlans());
                paymentPlans.forEach(paymentPlan -> paymentPlan.setPaymentMethod(savedPaymentMethod));
                savedPaymentMethod.setPaymentPlans(paymentPlans);
                BeanUtilsBean notNull  =new NullAwareBeanUtilsBean();
                notNull.copyProperties(savedPaymentMethod, paymentMethod);
                repository.save(savedPaymentMethod);
                return UpdatePaymentMethodResponse.builder().status(HttpStatus.OK.value()).message("Successful updated.")
                        .isSuccess(true).build();
            }else{
                return UpdatePaymentMethodResponse.builder().isSuccess(false)
                        .message("No payment method found against this id.").status(HttpStatus.NOT_FOUND.value()).build();
            }
        }catch (IllegalAccessException | InvocationTargetException exception){
            log.error(exception.getMessage());
            return UpdatePaymentMethodResponse.builder().isSuccess(false)
                    .message("Something went wrong.").status(HttpStatus.INTERNAL_SERVER_ERROR.value()).build();
        }
    }

}
