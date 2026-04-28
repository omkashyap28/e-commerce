package com.omkashyap.com.backend.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;

@Entity
@Getter
@NoArgsConstructor
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

  @CreationTimestamp
  private LocalDateTime createdAt;

}
