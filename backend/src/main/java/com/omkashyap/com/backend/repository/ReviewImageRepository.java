package com.omkashyap.com.backend.repository;

import com.omkashyap.com.backend.entity.ReviewImage;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ReviewImageRepository extends JpaRepository<ReviewImage, Long> {
  List<ReviewImage> findAllByReview_Id(Long id);
}