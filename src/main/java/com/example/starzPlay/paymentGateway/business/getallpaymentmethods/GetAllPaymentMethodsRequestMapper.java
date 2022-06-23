package com.example.starzPlay.paymentGateway.business.getallpaymentmethods;

import com.example.starzPlay.paymentGateway.business.getallpaymentmethods.request.GetAllPaymentMethodsInternalRequest;
import com.example.starzPlay.paymentGateway.business.getallpaymentmethods.request.GetAllPaymentMethodsRequest;
import com.example.starzPlay.paymentGateway.operational.RequestMapper;
import org.springframework.stereotype.Component;

@Component
public class GetAllPaymentMethodsRequestMapper implements RequestMapper<GetAllPaymentMethodsRequest, GetAllPaymentMethodsInternalRequest> {
    @Override
    public GetAllPaymentMethodsInternalRequest mapRequest(GetAllPaymentMethodsRequest req) {
        return GetAllPaymentMethodsInternalRequest.builder().id(req.getId()).name(req.getName()).build();
    }
}
