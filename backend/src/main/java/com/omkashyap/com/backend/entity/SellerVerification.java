package com.omkashyap.com.backend.entity;

import jakarta.persistence.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;

@Entity
public class SellerVerification {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @OneToOne(mappedBy = "sellerVerification")
  private Seller seller;

  @Column(
      length = 15,
      unique = true,
      nullable = false
  )
  private String gstNo;

  @Column(
      length = 10,
      unique = true,
      nullable = false
  )
  private String panNo;

  @Column(
      updatable = false
  )
  @CreationTimestamp
  private LocalDateTime createdAt;

  @UpdateTimestamp
  private LocalDateTime updatedAt;
}
