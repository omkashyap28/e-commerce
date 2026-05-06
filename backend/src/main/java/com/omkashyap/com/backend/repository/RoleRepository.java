package com.omkashyap.com.backend.repository;

import com.omkashyap.com.backend.entity.Role;
import com.omkashyap.com.backend.type.RoleEnum;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface RoleRepository extends JpaRepository<Role, Long> {

  Optional<Role> findByRole(RoleEnum roleEnum);
}
