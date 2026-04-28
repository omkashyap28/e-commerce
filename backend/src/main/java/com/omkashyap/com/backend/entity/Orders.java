package com.omkashyap.com.backend.entity;

import com.omkashyap.com.backend.type.OrderStatusEnum;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@NoArgsConstructor
@Table(
    indexes = {
        @Index(name = "idx_order_orderid", columnList = "order_id")
    },
    uniqueConstraints = {
        @UniqueConstraint(name = "uk_order_orderid", columnNames = "order_id")
    }
)
public class Orders {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Column(
      nullable = false,
      length = 30
  )
  private String orderId;

  @ManyToOne(
      fetch = FetchType.LAZY
  )
  @JoinColumn(
      name = "user_id",
      nullable = false,
      foreignKey = @ForeignKey(
          name = "fk_orders_userid"
      )
  )
  private User user;

  @Enumerated(EnumType.STRING)
  @Column(
      nullable = false
  )
  private OrderStatusEnum status;

  @Column(
      nullable = false
  )
  private Double amount;

  @OneToMany(
      mappedBy = "order",
      cascade = CascadeType.ALL,
      orphanRemoval = true
  )
  private List<OrderItem> items = new ArrayList<>();

  public Orders(String orderId, User user, OrderStatusEnum status, Double amount, List<OrderItem> orderItems) {
    this.orderId = orderId;
    this.user = user;
    this.status = OrderStatusEnum.CREATED;
    this.amount = amount;
  }

  public void addOrderItem(OrderItem item) {
    items.add(item);
    item.assignOrder(this);
  }

  public void removeItem(OrderItem item) {
    items.remove(item);
    item.removeOrder();
  }

  public void updateStatus(OrderStatusEnum status) {
    this.status = status;
  }
}
