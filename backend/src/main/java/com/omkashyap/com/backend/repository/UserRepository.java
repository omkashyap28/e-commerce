package com.omkashyap.com.backend.repository;

import com.omkashyap.com.backend.entity.User;
import com.omkashyap.com.backend.type.LoginProviderType;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {

  Optional<User> findByEmail(String email);

  boolean existsByEmail(String email);

  boolean existsByContact(String contact);

  @EntityGraph(attributePaths = "addresses")
  Optional<User> findByUserId(String publicId);


  void deleteByUserId(String userId);

  Boolean existsByUserId(String userId);

  Optional<User> findByProviderIdAndProviderType(String providerId, LoginProviderType loginProviderType);
}