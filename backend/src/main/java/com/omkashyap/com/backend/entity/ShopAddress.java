package com.omkashyap.com.backend.entity;

import jakarta.persistence.*;

@Entity
public class ShopAddress {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @OneToOne(
      mappedBy = "shopAddress"
  )
  private Seller seller;

  @Column(nullable = false, length = 100)
  private String street;

  @Column(nullable = false, length = 100)
  private String city;

  @Column(nullable = false, length = 100)
  private String state;

  @Column(nullable = false, length = 20)
  private String postalCode;

  @Column(nullable = false, length = 100)
  private String country;

  private Boolean isDefault = true;
}
