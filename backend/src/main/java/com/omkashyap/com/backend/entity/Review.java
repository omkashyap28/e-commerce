package com.omkashyap.com.backend.entity;

import jakarta.persistence.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(
    indexes = {
        @Index(name = "idx_product_productid", columnList = "product_id"),
        @Index(name = "idx_user_userid", columnList = "user_id"),
    },
    uniqueConstraints = @UniqueConstraint(
        columnNames = {"user_id", "product_id"}
    )
)
public class Review {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @ManyToOne(
      fetch = FetchType.LAZY
  )
  @JoinColumn(
      nullable = false,
      name = "product_id",
      foreignKey = @ForeignKey(
          name = "fk_product_productid"
      )
  )
  private Product product;

  @ManyToOne(
      fetch = FetchType.LAZY
  )
  @JoinColumn(
      nullable = false,
      name = "user_id",
      foreignKey = @ForeignKey(
          name = "fk_user_userid"
      )
  )
  private User user;

  @OneToOne
  @JoinColumn(
      name = "rating_id"
  )
  private ProductRating rating;

  @OneToOne(
      mappedBy = "review",
      orphanRemoval = true,
      cascade = CascadeType.ALL,
      fetch = FetchType.EAGER
  )
  private ReviewContent reviewContent;

  @OneToMany(
      mappedBy = "review",
      orphanRemoval = true,
      cascade = CascadeType.ALL,
      fetch = FetchType.EAGER
  )
  private List<ReviewImage> reviewImage;

  @CreationTimestamp
  @Column(
      updatable = false,
      insertable = false
  )
  private LocalDateTime createdAt;

  @UpdateTimestamp
  private LocalDateTime updatedAt;

}
