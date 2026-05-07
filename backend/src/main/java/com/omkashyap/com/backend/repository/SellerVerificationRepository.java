package com.omkashyap.com.backend.repository;

import com.omkashyap.com.backend.entity.SellerVerification;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SellerVerificationRepository extends JpaRepository<SellerVerification, Long> {

  Boolean existsBySeller_SellerId(String sellerId);
}
