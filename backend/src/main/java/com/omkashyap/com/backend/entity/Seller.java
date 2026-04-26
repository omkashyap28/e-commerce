package com.omkashyap.com.backend.entity;

import com.omkashyap.com.backend.type.ShopCategoryEnum;
import jakarta.persistence.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;
import java.util.List;

@Entity
public class Seller {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @OneToOne(
      orphanRemoval = true,
      cascade = CascadeType.REMOVE
  )
  @JoinColumn(
      name = "user_id",
      foreignKey = @ForeignKey(name = "fk_user_id")
  )
  private User user;

  @Column(
      nullable = false,
      unique = true,
      updatable = false
  )
  private String sellerId;

  @Column(
      nullable = false,
      length = 100
  )
  private String shopName;

  @Column(
      length = 200
  )
  private String description;

  @OneToMany(
      orphanRemoval = true,
      mappedBy = "seller",
      cascade = CascadeType.ALL
  )
  private List<Product> products;

  private Float averageRating;

  private Integer ratingCount;

  @Enumerated(EnumType.STRING)
  @Column(
      nullable = false
  )
  private ShopCategoryEnum shopCategoryEnum;

  @OneToOne(
      cascade = CascadeType.ALL
  )
  @JoinColumn(
      name = "varification_id",
      foreignKey = @ForeignKey(name = "fk_varification_id")
  )
  private SellerVerification sellerVerification;

  @OneToOne(
      cascade = CascadeType.ALL,
      orphanRemoval = true
  )
  @JoinColumn(
      name = "bank_id",
      foreignKey = @ForeignKey(name = "fk_bank_id")
  )
  private SellerBank sellerBank;

  @OneToOne(
      cascade = CascadeType.ALL,
      orphanRemoval = true
  )
  @JoinColumn(
      name = "shop_address_id",
      foreignKey = @ForeignKey(name = "fk_shop_address_id")
  )
  private ShopAddress shopAddress;

  @CreationTimestamp
  private LocalDateTime createdAt;

  @UpdateTimestamp
  private LocalDateTime updatedAt;
}
