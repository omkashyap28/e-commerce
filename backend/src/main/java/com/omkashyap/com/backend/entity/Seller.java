package com.omkashyap.com.backend.entity;

import ch.qos.logback.classic.net.SMTPAppender;
import com.omkashyap.com.backend.type.ShopCategoryEnum;
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
        @Index(name = "idx_seller_userid", columnList = "user_id"),
        @Index(name = "idx_seller_sellerid", columnList = "seller_id")
    },
    uniqueConstraints = {
        @UniqueConstraint(name = "uk_seller_productuserid", columnNames = {"user_id", "seller_id"}),
        @UniqueConstraint(name = "uk_seller_usedid", columnNames = "user_id")
    }
)
public class Seller {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @OneToOne(
      fetch = FetchType.EAGER
  )
  @JoinColumn(
      name = "user_id",
      foreignKey = @ForeignKey(name = "fk_seller_userid")
  )
  private User user;

  @Column(
      nullable = false,
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
      mappedBy = "seller",
      cascade = CascadeType.ALL,
      orphanRemoval = true
  )
  private SellerVerification sellerVerification;

  @OneToOne(
      cascade = CascadeType.ALL,
      orphanRemoval = true,
      mappedBy = "seller"
  )
  private SellerBank sellerBank;

  @OneToOne(
      cascade = CascadeType.ALL,
      orphanRemoval = true,
      mappedBy = "seller"
  )
  private ShopAddress shopAddress;

  @CreationTimestamp
  private LocalDateTime createdAt;

  @UpdateTimestamp
  private LocalDateTime updatedAt;
}
