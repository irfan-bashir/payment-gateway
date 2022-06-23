package com.example.starzPlay.paymentGateway.business.getallpaymentmethods;

import com.example.starzPlay.paymentGateway.business.getallpaymentmethods.request.GetAllPaymentMethodsInternalRequest;
import com.example.starzPlay.paymentGateway.business.getallpaymentmethods.response.GetAllPaymentMethodsResponse;
import com.example.starzPlay.paymentGateway.entities.PaymentMethod;
import com.example.starzPlay.paymentGateway.operational.Business;
import com.example.starzPlay.paymentGateway.repositories.PaymentMethodRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;

import java.util.Collections;
import java.util.List;
import java.util.Optional;


import static java.util.Objects.nonNull;

@Component
@Slf4j
public class GetAllPaymentMethodsBusiness implements Business<GetAllPaymentMethodsInternalRequest, GetAllPaymentMethodsResponse> {
    @Autowired
    PaymentMethodRepository repository;

    @Override
    public GetAllPaymentMethodsResponse perform(GetAllPaymentMethodsInternalRequest input) {
        try {
            if (nonNull(input.getId())){
                Optional<PaymentMethod> paymentMethods = repository.findById(input.getId());
                if (paymentMethods.isPresent()){
                    return GetAllPaymentMethodsResponse.builder().status(HttpStatus.OK.value()).message("Success")
                            .isSuccess(true).paymentMethodsList(Collections.singletonList(paymentMethods.get())).build();
                }
            }else if(nonNull(input.getName())){
                List<PaymentMethod> paymentMethods = repository.findByName(input.getName());
                return GetAllPaymentMethodsResponse.builder().status(HttpStatus.OK.value()).message("Success")
                        .isSuccess(true).paymentMethodsList(paymentMethods).build();
            }else {
                List<PaymentMethod> paymentMethods = repository.findAll();
                return GetAllPaymentMethodsResponse.builder().status(HttpStatus.OK.value()).message("Success")
                        .isSuccess(true).paymentMethodsList(paymentMethods).build();
            }
        }catch (Exception e){
            log.error("Exception occurred during fetching payment methods and exception message:" + e.getMessage());
            return GetAllPaymentMethodsResponse.builder().status(HttpStatus.INTERNAL_SERVER_ERROR.value())
                    .paymentMethodsList(null).build();
        }
        return null;
    }
}
