package com.omkashyap.com.backend.entity;

import jakarta.persistence.*;
import jdk.jfr.Timestamp;
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
@NoArgsConstructor
@Table(
    indexes = {
        @Index(name = "idx_wish_list_userid", columnList = "user_id")
    },
    uniqueConstraints = @UniqueConstraint(name = "uk_wish_list_userid", columnNames = "user_id")
)
public class WishList {

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
      mappedBy = "wishList",
      cascade = CascadeType.ALL,
      orphanRemoval = true
  )
  private List<WishListItem> items;

  @CreationTimestamp
  @Column(
      updatable = false
  )
  private LocalDateTime createdAt;

  @UpdateTimestamp
  private LocalDateTime updatedAt;
}
