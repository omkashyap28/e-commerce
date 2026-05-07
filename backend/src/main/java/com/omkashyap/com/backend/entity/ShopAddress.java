package com.omkashyap.com.backend.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(
    indexes = @Index(name = "idx_shop_address_sellerid", columnList = "seller_id")
)
public class ShopAddress {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @JsonIgnore
  @OneToOne(
      fetch = FetchType.LAZY
  )
  @JoinColumn(
      name = "seller_id",
      foreignKey = @ForeignKey(name = "fk_address_sellerid")
  )
  private Seller seller;

  @Column(
      nullable = false
  )
  private String address;

  @Column(nullable = false, length = 100)
  private String street;

  @Column(nullable = false, length = 100)
  private String city;

  @Column(nullable = false, length = 100)
  private String state;

  @Column(nullable = false, length = 20)
  private String postalCode;

  @Column(nullable = false, length = 100)
  private String country;

  @Column(
      updatable = false
  )
  @CreationTimestamp
  private LocalDateTime createdAt;

  @UpdateTimestamp
  private LocalDateTime updatedAt;
}
