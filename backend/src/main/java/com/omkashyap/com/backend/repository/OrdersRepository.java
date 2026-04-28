package com.omkashyap.com.backend.repository;

import com.omkashyap.com.backend.entity.Orders;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrdersRepository extends JpaRepository<Orders, Long> {
}