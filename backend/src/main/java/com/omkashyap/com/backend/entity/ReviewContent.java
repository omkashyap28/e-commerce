package com.omkashyap.com.backend.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(
    indexes = {
        @Index(name = "idx_review_reviewid", columnList = "review_id")
    },
    uniqueConstraints = @UniqueConstraint(
        name = "uk_review_content_reviewid", columnNames = "review_id"
    )
)
public class ReviewContent {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @OneToOne(
      fetch = FetchType.EAGER
  )
  @JoinColumn(
      name = "review_id",
      nullable = false,
      updatable = false,
      foreignKey = @ForeignKey(
          name = "fk_review_content_reviewid"
      )
  )
  private Review review;

  @Column(
      nullable = false,
      length = 255
  )
  private String content;

}
