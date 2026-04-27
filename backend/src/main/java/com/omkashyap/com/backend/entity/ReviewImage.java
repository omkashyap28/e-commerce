package com.omkashyap.com.backend.entity;

import jakarta.persistence.*;

@Entity
@Table(
    indexes = {
        @Index(
            name = "idx_review_reviewid", columnList = "review_id"
        )
    }
)
public class ReviewImage {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @ManyToOne
  @JoinColumn(
      name = "review_id",
      nullable = false,
      foreignKey = @ForeignKey(
          name = "fk_review_reviewid"
      )
  )
  private Review review;

  @Column(
      unique = true,
      nullable = false
  )
  private String imageUrl;

}
