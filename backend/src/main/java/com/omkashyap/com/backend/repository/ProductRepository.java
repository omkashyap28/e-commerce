package com.omkashyap.com.backend.repository;

import com.omkashyap.com.backend.entity.Product;
import com.omkashyap.com.backend.entity.Seller;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface ProductRepository extends JpaRepository<Product, Long> {
  Optional<Product> findByProductId(String productId);

  List<Product> findAllBySeller(Seller seller);

  Boolean existsByProductId(String productId);
}