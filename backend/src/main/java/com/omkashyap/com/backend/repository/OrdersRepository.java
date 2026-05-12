package com.omkashyap.com.backend.repository;

import com.omkashyap.com.backend.entity.Orders;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface OrdersRepository extends JpaRepository<Orders, Long> {

  Optional<Orders> findByUser_UserId(String userId);
}