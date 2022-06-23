package com.example.starzPlay.paymentGateway.repositories;

import com.example.starzPlay.paymentGateway.entities.PaymentPlan;
import org.springframework.data.jpa.repository.JpaRepository;

import java.math.BigDecimal;

public interface PaymentPlanRepository extends JpaRepository<PaymentPlan, BigDecimal> {
}
