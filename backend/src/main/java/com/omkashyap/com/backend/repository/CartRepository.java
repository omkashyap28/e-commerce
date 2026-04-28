package com.omkashyap.com.backend.repository;

import com.omkashyap.com.backend.entity.Cart;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CartRepository extends JpaRepository<Cart, Long> {
}