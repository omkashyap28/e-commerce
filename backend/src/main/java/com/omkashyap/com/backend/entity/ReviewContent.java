package com.omkashyap.com.backend.entity;

import jakarta.persistence.*;

@Entity
@Table(
    indexes = {
        @Index(name = "idx_review_reviewid", columnList = "review_id")
    }
)
public class ReviewContent {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @OneToOne
  @JoinColumn(
      name = "review_id",
      nullable = false,
      updatable = false,
      foreignKey = @ForeignKey(
          name = "fk_review_reviewid"
      )
  )
  private Review review;

  @Column(
      nullable = false,
      length = 255
  )
  private String content;

}
