package com.omkashyap.com.backend.repository;

import com.omkashyap.com.backend.entity.Payment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PaymentRepository extends JpaRepository<Payment, Long> {
}