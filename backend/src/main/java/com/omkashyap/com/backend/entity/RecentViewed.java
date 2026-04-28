package com.omkashyap.com.backend.entity;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Table(
    indexes = {
        @Index(name = "idx_recent_user", columnList = "user_id"),
        @Index(name = "idx_recent_viewedAt", columnList = "viewedAt")
    }
)
public class RecentViewed {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @ManyToOne(
      fetch = FetchType.LAZY
  )
  @JoinColumn(
      name = "user_id",
      nullable = false,
      foreignKey = @ForeignKey(
          name = "fk_viewed_userid"
      )
  )
  private User user;

  @ManyToOne(
      fetch = FetchType.LAZY
  )
  @JoinColumn(
      name = "product_attribute_id",
      nullable = false,
      foreignKey = @ForeignKey(
          name = "fk_viewed_attributeid"
      )
  )
  private ProductAttribute productAttribute;

  @CreationTimestamp
  private LocalDateTime viewedAt;

  public RecentViewed(User user, ProductAttribute productAttribute) {
    this.user = user;
    this.productAttribute = productAttribute;
  }
}
