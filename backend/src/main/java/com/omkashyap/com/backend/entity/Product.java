package com.omkashyap.com.backend.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(
    indexes = {
        @Index(name = "idx_product_productid", columnList = "product_id"),
        @Index(name = "idx_product_sellerid", columnList = "seller_id")
    },
    uniqueConstraints = @UniqueConstraint(name = "uk_product_productid", columnNames = "product_id")
)
public class Product {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Column(
      nullable = false,
      length = 30
  )
  private String productId;

  @Column(
      nullable = false
  )
  private String title;

  private String description;

  @OneToMany(
      mappedBy = "product",
      orphanRemoval = true,
      cascade = CascadeType.ALL
  )
  private List<ProductImage> images;


  @OneToMany(
      mappedBy = "product",
      cascade = CascadeType.ALL,
      orphanRemoval = true
  )
  private List<ProductAttribute> attributes;

  @OneToMany(
      mappedBy = "product",
      cascade = CascadeType.ALL,
      orphanRemoval = true
  )
  private List<Review> review;

  @ManyToOne(
      fetch = FetchType.EAGER
  )
  @JoinColumn(
      name = "seller_id",
      nullable = false,
      foreignKey = @ForeignKey(
          name = "fk_product_sellerid"
      )
  )
  private Seller seller;

  private Integer quantity;

  private Integer totalReviews;

  private Float averageRating;

  @OneToMany(
      mappedBy = "product",
      cascade = CascadeType.ALL,
      orphanRemoval = true
  )
  private List<ProductDiscussion> discussions;

  @OneToMany(
      mappedBy = "product",
      cascade = CascadeType.ALL,
      orphanRemoval = true
  )
  private List<ProductAttribute> productAttribute;

  @CreationTimestamp
  private LocalDateTime createdAt;

  @UpdateTimestamp
  private LocalDateTime updatedAt;

}
