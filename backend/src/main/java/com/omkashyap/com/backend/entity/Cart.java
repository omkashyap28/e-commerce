package com.omkashyap.com.backend.entity;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(
    indexes = @Index(
        name = "idx_cart_userid", columnList = "user_id"
    ),
    uniqueConstraints = {
        @UniqueConstraint(
            name = "uk_cart_userid", columnNames = "user_id"
        )
    }
)
public class Cart {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @OneToOne(
      fetch = FetchType.LAZY
  )
  @JoinColumn(
      name = "user_id"
  )
  private User user;

  @OneToMany(
      mappedBy = "cart",
      cascade = CascadeType.DETACH,
      orphanRemoval = true
  )
  @Builder.Default
  private List<CartItem> cartItem = new ArrayList<>();

  @CreationTimestamp
  private LocalDateTime createdAt;
}
