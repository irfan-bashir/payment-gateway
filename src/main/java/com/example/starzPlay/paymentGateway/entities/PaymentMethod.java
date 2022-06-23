package com.example.starzPlay.paymentGateway.entities;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Set;

@Entity
@Table(name = "payment_methods")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class PaymentMethod extends BaseEntity implements Serializable {
    @Column(name = "id")
    private BigDecimal id;

    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "name")
    private String name;

    @Column(name = "display_name")
    private String displayName;

    @Size(max = 50)
    @Column(name = "payment_type")
    private String paymentType;
  
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "paymentMethod", fetch = FetchType.LAZY)
    private Set<PaymentPlan> paymentPlans;
}
