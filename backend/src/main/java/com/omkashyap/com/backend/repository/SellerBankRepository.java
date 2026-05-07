package com.omkashyap.com.backend.repository;

import com.omkashyap.com.backend.entity.SellerBank;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SellerBankRepository extends JpaRepository<SellerBank, Long> {
  boolean existsBySeller_SellerId(String sellerId);
}
