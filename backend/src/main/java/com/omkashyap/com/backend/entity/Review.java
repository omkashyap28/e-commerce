package com.omkashyap.com.backend.entity;

import jakarta.persistence.*;
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
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(
    indexes = {
        @Index(name = "idx_review_productid", columnList = "product_id"),
        @Index(name = "idx_review_userid", columnList = "user_id"),
    },
    uniqueConstraints = {
        @UniqueConstraint(
            name = "uk_review_productuserid", columnNames = {"user_id", "product_id"}
        ),
        @UniqueConstraint(
            name = "uk_review_reviewid", columnNames = "review_id"
        )
    }
)
public class Review {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @ManyToOne(
      fetch = FetchType.EAGER
  )
  @JoinColumn(
      nullable = false,
      name = "product_id",
      foreignKey = @ForeignKey(
          name = "fk_review_productid"
      )
  )
  private Product product;

  @ManyToOne(
      fetch = FetchType.EAGER
  )
  @JoinColumn(
      nullable = false,
      name = "user_id",
      foreignKey = @ForeignKey(
          name = "fk_review_userid"
      )
  )
  private User user;

  @OneToOne(
      fetch = FetchType.EAGER
  )
  @JoinColumn(
      name = "rating_id",
      foreignKey = @ForeignKey(
          name = "fk_review_productrating"
      )
  )
  private ProductRating rating;

  @OneToOne(
      mappedBy = "review",
      orphanRemoval = true,
      cascade = CascadeType.ALL
  )
  private ReviewContent reviewContent;

  @OneToMany(
      mappedBy = "review",
      orphanRemoval = true,
      cascade = CascadeType.ALL
  )
  private List<ReviewImage> reviewImage;

  @CreationTimestamp
  @Column(
      updatable = false,
      insertable = false
  )
  private LocalDateTime createdAt;

  @UpdateTimestamp
  private LocalDateTime updatedAt;

}
