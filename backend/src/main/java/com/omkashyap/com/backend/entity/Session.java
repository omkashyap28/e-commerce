package com.omkashyap.com.backend.entity;

import jakarta.persistence.*;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDate;

@Entity
public class Session {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @ManyToOne
  @JoinColumn(
      name = "user_id", nullable = false
  )
  private User user;

  @Column(
      nullable = false,
      unique = true
  )
  private String sessionToken;

  private String device;

  private String ipAddress;

  private LocalDate expiresAt;

  @CreationTimestamp
  private LocalDate createdAt;

  private Boolean isActive = true;
}
