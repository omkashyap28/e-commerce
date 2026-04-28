package com.omkashyap.com.backend.repository;

import com.omkashyap.com.backend.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category, Long> {
}