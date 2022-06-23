package com.example.starzPlay.paymentGateway.business.getallpaymentmethods;

import com.example.starzPlay.paymentGateway.business.getallpaymentmethods.response.GetAllPaymentMethodsResponse;
import com.example.starzPlay.paymentGateway.operational.ResponseMapper;
import org.springframework.stereotype.Component;

@Component
public class GetAllPaymentMethodsResponseMapper implements ResponseMapper<GetAllPaymentMethodsResponse, GetAllPaymentMethodsResponse> {
    @Override
    public GetAllPaymentMethodsResponse mapResponse(GetAllPaymentMethodsResponse response) {
        return response;
    }
}
