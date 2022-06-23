package com.example.starzPlay.paymentGateway.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.math.BigDecimal;

@Entity
@Table(name = "payment_plans")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class PaymentPlan extends BaseEntity implements Serializable {
    @Column(name = "id")
    private BigDecimal id;

    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "net_amount")
    private String netAmount;

    @Column(name = "tax_amount")
    private String taxAmount;

    @Size(max = 50)
    @Column(name = "gross_amount")
    private String description;

    @NotNull
    @Column(name = "currency")
    private String currency;

    @NotNull
    @Column(name = "duration")
    private String duration;

    @ManyToOne(cascade = CascadeType.ALL, optional = false, fetch = FetchType.LAZY)
    @JsonIgnore
    @JoinColumn(name = "payment_method_id", referencedColumnName = "id", nullable = false)
    private PaymentMethod paymentMethod;
}
