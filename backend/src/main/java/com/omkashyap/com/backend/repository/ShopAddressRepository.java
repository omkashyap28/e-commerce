package com.omkashyap.com.backend.repository;

import com.omkashyap.com.backend.entity.ShopAddress;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ShopAddressRepository extends JpaRepository<ShopAddress, Long> {
  boolean existsBySellerId(Object unknownAttr1);

  Optional<ShopAddress> findBySeller_SellerId(String sellerId);
}
