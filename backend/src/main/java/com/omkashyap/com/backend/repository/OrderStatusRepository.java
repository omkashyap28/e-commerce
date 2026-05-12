package com.omkashyap.com.backend.repository;

import com.omkashyap.com.backend.entity.OrderStatus;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderStatusRepository extends JpaRepository<OrderStatus, Long> {
}
