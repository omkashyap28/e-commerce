package com.omkashyap.com.backend.entity;

import jakarta.persistence.*;

@Entity
public class SellerBank {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @OneToOne(
      mappedBy = "sellerBank"
  )
  private Seller seller;

  @Column(
      nullable = false,
      unique = true,
      length = 20
  )
  private String accountNo;

  @Column(
      nullable = false
  )
  private String bankName;

  @Column(
      nullable = false
  )
  private String ifscCode;
}
