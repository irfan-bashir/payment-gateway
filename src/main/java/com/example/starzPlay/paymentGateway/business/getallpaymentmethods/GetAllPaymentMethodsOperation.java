package com.example.starzPlay.paymentGateway.business.getallpaymentmethods;

import com.example.starzPlay.paymentGateway.business.getallpaymentmethods.request.GetAllPaymentMethodsInternalRequest;
import com.example.starzPlay.paymentGateway.business.getallpaymentmethods.request.GetAllPaymentMethodsRequest;
import com.example.starzPlay.paymentGateway.business.getallpaymentmethods.response.GetAllPaymentMethodsResponse;
import com.example.starzPlay.paymentGateway.operational.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class GetAllPaymentMethodsOperation extends OperationTemplate<GetAllPaymentMethodsRequest, GetAllPaymentMethodsResponse,
        GetAllPaymentMethodsInternalRequest, GetAllPaymentMethodsResponse> {

    @Autowired
    private GetAllPaymentMethodsRequestValidator validator;

    @Autowired
    private GetAllPaymentMethodsBusiness business;

    @Autowired
    private GetAllPaymentMethodsRequestMapper requestMapper;

    @Autowired
    private GetAllPaymentMethodsResponseMapper responseMapper;


    @Override
    protected Validator<GetAllPaymentMethodsRequest> getValidator() {return validator;}

    @Override
    protected Business<GetAllPaymentMethodsInternalRequest, GetAllPaymentMethodsResponse> getBusiness() {
        return business;
    }

    @Override
    protected RequestMapper<GetAllPaymentMethodsRequest, GetAllPaymentMethodsInternalRequest> getRequestMapper() {
        return requestMapper;
    }

    @Override
    protected ResponseMapper<GetAllPaymentMethodsResponse, GetAllPaymentMethodsResponse> getResponseMapper() {
        return responseMapper;
    }

}
