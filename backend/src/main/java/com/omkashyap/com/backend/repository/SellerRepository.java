package com.omkashyap.com.backend.repository;

import com.omkashyap.com.backend.entity.Seller;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SellerRepository extends JpaRepository<Seller, Long> {
}