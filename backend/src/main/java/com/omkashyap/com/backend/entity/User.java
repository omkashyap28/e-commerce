package com.omkashyap.com.backend.entity;

import com.omkashyap.com.backend.type.GenderEnum;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(
    indexes = {
        @Index(name = "idx_user_email", columnList = "email"),
        @Index(name = "idx_user_contact", columnList = "contact")
    },
    uniqueConstraints = {
        @UniqueConstraint(name = "uk_user_contact", columnNames = "contact"),
        @UniqueConstraint(name = "uk_user_email", columnNames = "email")
    }
)
public class User {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Column(
      nullable = false,
      length = 50
  )
  private String firstName;

  @Column(
      nullable = false,
      length = 50
  )
  private String lastName;

  @Column(
      nullable = false,
      length = 100,
      unique = true
  )
  private String email;

  @Column(
      nullable = false,
      length = 15,
      unique = true
  )
  private String contact;

  @Enumerated(EnumType.STRING)
  @Column(
      nullable = false
  )
  private GenderEnum gender;

  @Column(
      nullable = false
  )
  private LocalDate dateOfBirth;

  @ManyToMany
  @JoinTable(
      name = "user_roles",
      joinColumns = @JoinColumn(name = "user_id"),
      inverseJoinColumns = @JoinColumn(name = "role_id")
  )
  private List<Role> roles;

  @Column(
      length = 255
  )
  private String password;

  @OneToMany(
      mappedBy = "user",
      cascade = CascadeType.ALL,
      orphanRemoval = true
  )
  private List<Address> addresses;

  @OneToMany(
      mappedBy = "user",
      cascade = CascadeType.ALL,
      orphanRemoval = true
  )
  private List<Session> sessions;

  @Column(updatable = false)
  @CreationTimestamp
  private LocalDateTime createdAt;

  @UpdateTimestamp
  private LocalDateTime updatedAt;
}
