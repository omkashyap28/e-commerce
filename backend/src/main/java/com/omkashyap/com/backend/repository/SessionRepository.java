package com.omkashyap.com.backend.repository;

import com.omkashyap.com.backend.entity.Session;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface SessionRepository extends JpaRepository<Session, Long> {
  Optional<Session> findByAccessToken(String token);

  @Modifying
  @Query("DELETE FROM Session s WHERE s.accessToken = :token")
  void deleteByAccessToken(String token);
}
