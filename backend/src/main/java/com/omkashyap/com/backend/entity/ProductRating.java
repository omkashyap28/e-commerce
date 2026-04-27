package com.omkashyap.com.backend.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.Generated;

import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(
    uniqueConstraints = @UniqueConstraint(
        name = "uk_product_rating_productuserid", columnNames = {"user_id", "product_id"}
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
      nullable = false,
      foreignKey = @ForeignKey(
          name = "fk_product_rating_userid"
      )
  )
  private User user;

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(
      name = "product_id",
      nullable = false,
      foreignKey = @ForeignKey(
          name = "fk_product_rating_productid"
      )
  )
  private Product product;

  @OneToOne(
      mappedBy = "rating",
      cascade = CascadeType.ALL,
      orphanRemoval = true
  )
  private Review review;

  @CreationTimestamp
  private LocalDateTime createdAt;
}
