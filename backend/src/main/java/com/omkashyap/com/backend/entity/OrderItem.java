package com.omkashyap.com.backend.entity;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class OrderItem {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @ManyToOne(
      fetch = FetchType.LAZY
  )
  @JoinColumn(
      name = "order_id",
      nullable = false,
      foreignKey = @ForeignKey(
          name = "fk_order_item_orderid"
      )
  )
  private Orders order;

  @ManyToOne(
      fetch = FetchType.LAZY
  )
  @JoinColumn(
      name = "product_attribute_id",
      nullable = false,
      foreignKey = @ForeignKey(
          name = "fk_order_item_attributeid"
      )
  )
  private ProductAttribute productAttribute;

  private Integer quantity;

  private Double price;

  public OrderItem(ProductAttribute productAttribute, Integer quantity, Double price) {
    this.productAttribute = productAttribute;
    this.quantity = quantity;
    this.price = price;
  }

  public void assignOrder(Orders order) {
    this.order = order;
  }

  public void removeOrder() {
    this.order = null;
  }
}
