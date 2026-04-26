package com.omkashyap.com.backend.entity;

import com.omkashyap.com.backend.type.RoleEnum;
import jakarta.persistence.*;

import java.util.List;

@Entity
public class Role {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Enumerated(EnumType.STRING)
  private RoleEnum role;

  @ManyToMany(
      mappedBy = "roles"
  )
  private List<User> user;
}
