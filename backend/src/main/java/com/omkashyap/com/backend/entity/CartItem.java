package com.omkashyap.com.backend.entity;

import jakarta.persistence.*;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;

@Entity
@Table(
    uniqueConstraints = @UniqueConstraint(
        name = "uk_cart_item_product_attr_id", columnNames = {"wishlist_id", "product_attribute_id"}
    )
)
public class CartItem {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @ManyToOne(
      fetch = FetchType.LAZY
  )
  @JoinColumn(
      name = "cart_id",
      nullable = false,
      foreignKey = @ForeignKey(
          name = "fk_cart_item_cartid"
      )
  )
  private Cart cart;

  @ManyToOne(
      fetch = FetchType.LAZY
  )
  @JoinColumn(
      name = "product_id",
      nullable = false,
      foreignKey = @ForeignKey(
          name = "fk_cart_item_productid"
      )
  )
  private Product product;

  @ManyToOne(
      fetch = FetchType.LAZY
  )
  @JoinColumn(
      name = "product_attribute_id",
      nullable = false,
      foreignKey = @ForeignKey(
          name = "fk_cart_item_attributetid"
      )
  )
  private ProductAttribute productAttribute;

  @CreationTimestamp
  private LocalDateTime createdAt;


}
