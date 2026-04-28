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
        @Index(name = "idx_search_user", columnList = "user_id"),
        @Index(name = "idx_search_text", columnList = "searchText")
    }
)
public class SearchHistory {

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
          name = "fk_search_userid"
      )
  )
  private User user;

  @Column(
      nullable = false,
      length = 100
  )
  private String searchText;

  @CreationTimestamp
  @Column(nullable = false)
  private LocalDateTime searchedAt;

  public SearchHistory(User user, String searchText, LocalDateTime searchedAt) {
    this.user = user;
    this.searchText = searchText;
  }
}
