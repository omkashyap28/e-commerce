package com.omkashyap.com.backend.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
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
      length = 32
  )
  private String productId;

  @Column(
      nullable = false
  )
  private String description;

  @OneToMany(
      mappedBy = "product",
      orphanRemoval = true,
      cascade = CascadeType.ALL
  )
  private List<ProductImage> productImages = new ArrayList<>();

  @OneToMany(
      mappedBy = "product",
      cascade = CascadeType.ALL,
      orphanRemoval = true
  )
  private List<Review> review = new ArrayList<>();

  @JsonIgnore
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

  private Boolean inStock;

  private Integer totalReviews;

  private Float averageRating;

  private Float price;

  @ManyToOne(
      fetch = FetchType.LAZY
  )
  @JoinColumn(
      name = "category_id",
      foreignKey = @ForeignKey(
          name = "fk_product_categoryid"
      )
  )
  private Category category;

  @OneToMany(
      mappedBy = "product",
      cascade = CascadeType.ALL,
      orphanRemoval = true
  )
  private List<ProductDiscussion> discussions = new ArrayList<>();

  @OneToMany(
      mappedBy = "product",
      cascade = CascadeType.ALL,
      orphanRemoval = true
  )
  @Builder.Default
  private List<ProductAttribute> productAttributes = new ArrayList<>();

  @CreationTimestamp
  private LocalDateTime createdAt;

  @UpdateTimestamp
  private LocalDateTime updatedAt;

  @PrePersist
  private void generateId() {
    if (this.productId == null) {
      this.productId = UUID.randomUUID().toString().replace("-", "");
    }
  }

  public void assignSeller(Seller seller) {
    this.seller = seller;
  }

}
