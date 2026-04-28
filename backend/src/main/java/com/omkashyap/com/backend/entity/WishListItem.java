package com.omkashyap.com.backend.entity;

import jakarta.persistence.*;

@Entity
@Table(
    uniqueConstraints = @UniqueConstraint(
        name = "uk_wishlist_product_attr_id", columnNames = {"wishlist_id", "product_attribute_id"}
    )
)
public class WishListItem {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @ManyToOne(
      fetch = FetchType.LAZY
  )
  @JoinColumn(
      name = "wishlist_id",
      nullable = false
  )
  private WishList wishList;

  @ManyToOne(
      fetch = FetchType.LAZY
  )
  @JoinColumn(
      name = "product_id",
      nullable = false
  )
  private Product product;

  @ManyToOne(
      fetch = FetchType.LAZY
  )
  @JoinColumn(
      name = "product_attribute_id",
      nullable = false
  )
  private ProductAttribute productAttribute;

}
