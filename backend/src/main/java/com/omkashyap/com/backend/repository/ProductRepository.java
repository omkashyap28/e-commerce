package com.omkashyap.com.backend.repository;

import com.omkashyap.com.backend.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {
}