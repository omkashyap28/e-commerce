package com.omkashyap.com.backend.entity;

import jakarta.persistence.*;

@Entity
public class Invoice {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @OneToOne(
      fetch = FetchType.LAZY
  )
  @JoinColumn(
      name = "order_id",
      foreignKey = @ForeignKey(
          name = "fk_invoice_orderid"
      )
  )
  private Orders order;

  @Column(
      nullable = false
  )
  private String invoiceNo;

  @Column(
      nullable = false
  )
  private String customerName;

  @Column(
      nullable = false
  )
  private String customerEmail;

  @Column(
      nullable = false
  )
  private String billingAddress;

  @Column(
      nullable = false
  )
  private Double totalAmount;

  @Column(
      nullable = false
  )
  private Double taxAmount;

}
