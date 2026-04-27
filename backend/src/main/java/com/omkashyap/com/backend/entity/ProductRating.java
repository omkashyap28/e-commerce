package com.omkashyap.com.backend.entity;

import jakarta.persistence.*;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;

@Entity
@Table(
    uniqueConstraints = @UniqueConstraint(
        columnNames = {"user_id", "product_id"}
    ),
    indexes = @Index(
        name = "idx_product_rating_product", columnList = "product_id"
    )
)
public class ProductRating {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Column(
      nullable = false
  )
  private Integer rating;

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(
      name = "user_id",
      nullable = false
  )
  private User user;

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(
      name = "product_id",
      nullable = false
  )
  private Product product;

  @CreationTimestamp
  private LocalDateTime createdAt;
}
