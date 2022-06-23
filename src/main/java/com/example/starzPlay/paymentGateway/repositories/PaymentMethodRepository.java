package com.example.starzPlay.paymentGateway.repositories;

import com.example.starzPlay.paymentGateway.entities.PaymentMethod;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.List;

@Repository
public interface PaymentMethodRepository extends JpaRepository<PaymentMethod, BigDecimal> {

    List<PaymentMethod> findByName(String name);
}
