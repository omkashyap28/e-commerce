package com.omkashyap.com.backend.repository;

import com.omkashyap.com.backend.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}