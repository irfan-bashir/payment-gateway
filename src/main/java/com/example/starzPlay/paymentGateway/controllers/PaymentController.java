package com.example.starzPlay.paymentGateway.controllers;

import com.example.starzPlay.paymentGateway.business.addpaymentmethod.AddPaymentMethodBusiness;
import com.example.starzPlay.paymentGateway.business.addpaymentmethod.request.AddPaymentMethodRequest;
import com.example.starzPlay.paymentGateway.business.addpaymentmethod.response.AddPaymentMethodResponse;
import com.example.starzPlay.paymentGateway.business.getallpaymentmethods.GetAllPaymentMethodsOperation;
import com.example.starzPlay.paymentGateway.business.getallpaymentmethods.request.GetAllPaymentMethodsRequest;
import com.example.starzPlay.paymentGateway.business.getallpaymentmethods.response.GetAllPaymentMethodsResponse;
import com.example.starzPlay.paymentGateway.business.updatepaymentmethod.response.UpdatePaymentMethodResponse;
import com.example.starzPlay.paymentGateway.entities.PaymentMethod;
import com.example.starzPlay.paymentGateway.services.PaymentMethodService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.math.BigDecimal;

@Slf4j
@RestController
@RequestMapping("api/v1.0/configuration/payment-methods")
public class PaymentController extends  BaseController{

    @Autowired
    private GetAllPaymentMethodsOperation getAllPaymentMethodsOperation;

    @Autowired
    private AddPaymentMethodBusiness addPaymentMethodBusiness;

    @Autowired
    private PaymentMethodService paymentMethodService;

    @GetMapping
    public ResponseEntity<GetAllPaymentMethodsResponse> getAllPayments(@RequestParam(name = "name", required = false) String name,
                                                                       @RequestParam(name = "id", required = false) BigDecimal id){
        return successResponse(getAllPaymentMethodsOperation.execute(GetAllPaymentMethodsRequest.builder().id(id)
                .name(name).build()), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<AddPaymentMethodResponse> addPaymentMethod(@Valid @RequestBody AddPaymentMethodRequest request){
        return ResponseEntity.ok(addPaymentMethodBusiness.execute(request));
    }

    @PutMapping
    public ResponseEntity<UpdatePaymentMethodResponse> updatePaymentMethod(@RequestParam(name = "payment-methods", required = true) BigDecimal id,
                                                                           @RequestBody PaymentMethod paymentMethod){
        return ResponseEntity.ok(paymentMethodService.business(id, paymentMethod));
    }
}
