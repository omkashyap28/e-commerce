package com.omkashyap.com.backend.entity;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(
    indexes = {
        @Index(name = "idx_product_productid", columnList = "productId"),
        @Index(name = "idx_product_seller", columnList = "seller_id")
    }
)
public class Product {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Column(
      nullable = false,
      unique = true,
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
      fetch = FetchType.LAZY
  )
  @JoinColumn(
      name = "seller_id",
      nullable = false
  )
  private Seller seller;

  private Boolean inStock;

  private Long totalReviews;

  private Double averageRating;

  @OneToMany(mappedBy = "product", cascade = CascadeType.ALL, orphanRemoval = true)
  private List<ProductDiscussion> discussions;

  @OneToMany(
      mappedBy = "product",
      cascade = CascadeType.ALL,
      orphanRemoval = true
  )
  private List<ProductAttribute> productAttribute;
}
