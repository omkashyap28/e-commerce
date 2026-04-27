package com.omkashyap.com.backend.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDate;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(
    indexes = {
        @Index(name = "idx_session_userid", columnList = "user_id")
    },
    uniqueConstraints = @UniqueConstraint(name = "uk_session_sessiontoken", columnNames = "session_token")
)
public class Session {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @ManyToOne
  @JoinColumn(
      name = "user_id",
      nullable = false,
      foreignKey = @ForeignKey(
          name = "fk_session_userid"
      )
  )
  private User user;

  @Column(
      nullable = false
  )
  private String sessionToken;

  private String device;

  private String ipAddress;

  private LocalDate expiresAt;

  @CreationTimestamp
  private LocalDate createdAt;

  private Boolean isActive = true;
}
