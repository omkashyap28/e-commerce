package com.omkashyap.com.backend.repository;

import com.omkashyap.com.backend.entity.Review;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReviewRepository extends JpaRepository<Review, Long> {
}