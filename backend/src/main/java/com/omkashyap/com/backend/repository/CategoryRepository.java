package com.omkashyap.com.backend.repository;

import com.omkashyap.com.backend.entity.Category;
import com.omkashyap.com.backend.type.CategoryEnum;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CategoryRepository extends JpaRepository<Category, Long> {
  Optional<Category> findByName(CategoryEnum categoryEnum);
}