package com.example.starzPlay.paymentGateway.business.getallpaymentmethods;

import com.example.starzPlay.paymentGateway.business.getallpaymentmethods.request.GetAllPaymentMethodsRequest;
import com.example.starzPlay.paymentGateway.operational.Validator;

import com.example.starzPlay.paymentGateway.utils.ValidationError;
import com.google.common.base.Preconditions;
import org.springframework.stereotype.Component;

import static java.util.Objects.nonNull;

@Component
public class GetAllPaymentMethodsRequestValidator implements Validator<GetAllPaymentMethodsRequest> {
    @Override
    public void validate(GetAllPaymentMethodsRequest input) {
        Preconditions.checkArgument(!(nonNull(input.getId()) && nonNull(input.getName())), ValidationError.NAME_AND_ID_NOT_ACCEPTABLE.getMessage());
    }
}
