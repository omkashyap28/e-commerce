package com.omkashyap.com.backend.repository;

import com.omkashyap.com.backend.entity.ProductAttribute;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductAttributeRepository extends JpaRepository<ProductAttribute, Long> {
}