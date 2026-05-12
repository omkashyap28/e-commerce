package com.omkashyap.com.backend.entity;

import com.omkashyap.com.backend.type.OrderStatusEnum;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class OrderStatus {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @OneToOne(
      fetch = FetchType.EAGER
  )
  @JoinColumn(
      name = "order_item_id",
      foreignKey = @ForeignKey(
          name = "fk_order_status_order_item_id"
      )
  )
  private OrderItem orderItem;

  @Enumerated(EnumType.STRING)
  private OrderStatusEnum orderStatus;

  @CreationTimestamp
  @Column(
      updatable = false
  )
  private LocalDateTime createdAt;

  private LocalDateTime confirmedAt;

  private LocalDateTime processedAt;

  private LocalDateTime shippedAt;

  private LocalDateTime outOfDeliveryAt;

  private LocalDateTime deliveredAt;

  private LocalDateTime cancelledAt;

  private LocalDateTime returnedAt;

  private LocalDateTime exchangedAt;

}
