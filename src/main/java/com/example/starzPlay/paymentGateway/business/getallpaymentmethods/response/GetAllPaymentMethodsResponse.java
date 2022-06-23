/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.starzPlay.paymentGateway.business.getallpaymentmethods.response;

import com.example.starzPlay.paymentGateway.entities.PaymentMethod;
import lombok.*;

import java.util.List;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class GetAllPaymentMethodsResponse {

    private int status;
    private String message;
    private Boolean isSuccess;
    private List<PaymentMethod> paymentMethodsList;
}
