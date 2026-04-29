package com.omkashyap.com.backend.entity;

import com.omkashyap.com.backend.type.PaymentMethodEnum;
import com.omkashyap.com.backend.type.PaymentStatusEnum;
import jakarta.persistence.*;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;

@Entity
@Table(
    indexes = @Index(name = "idx_payment_paymentid", columnList = "payment_id"),
    uniqueConstraints = {
        @UniqueConstraint(name = "uk_payment_paymentid", columnNames = "payment_id"),
        @UniqueConstraint(name = "uk_payment_orderid", columnNames = "order_id")
    }
)
public class Payment {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Column(
      nullable = false,
      length = 40
  )
  private String paymentId;

  @OneToOne(
      fetch = FetchType.LAZY
  )
  @JoinColumn(
      name = "order_id",
      foreignKey = @ForeignKey(
          name = "fk_payment_orderid"
      )
  )
  private Orders order;

  @Enumerated(EnumType.STRING)
  private PaymentMethodEnum paymentMethod;

  @Enumerated(EnumType.STRING)
  private PaymentStatusEnum paymentStatus;

  @Column(
      nullable = false,
      length = 100
  )
  private String transactionId;

  @CreationTimestamp
  @Column(
      updatable = false
  )
  private LocalDateTime createdAt;

}
