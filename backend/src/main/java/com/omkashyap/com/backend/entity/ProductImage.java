package com.omkashyap.com.backend.entity;

import jakarta.persistence.*;

@Entity
public class ProductImage {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @ManyToOne
  private Product product;

  @Column(
      nullable = false,
      unique = true
  )
  private String productUrl;

}
