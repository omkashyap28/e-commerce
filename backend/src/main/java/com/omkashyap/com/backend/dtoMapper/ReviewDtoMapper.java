package com.omkashyap.com.backend.dtoMapper;

import com.omkashyap.com.backend.dto.responseDto.ReviewResponseDto;
import com.omkashyap.com.backend.entity.Review;
import com.omkashyap.com.backend.entity.ReviewImage;
import com.omkashyap.com.backend.repository.ReviewImageRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class ReviewDtoMapper {

  private final ReviewImageRepository reviewImageRepository;

  public ReviewResponseDto mapToDto(Review review) {
    ReviewResponseDto dto = new ReviewResponseDto();
    dto.setReviewId(review.getReviewId());
    dto.setMessage(review.getMessage());
    dto.setRating(review.getRating());
    dto.setCreatedAt(review.getCreatedAt());

    List<ReviewImage> images = reviewImageRepository.findAllByReview_Id(review.getId());
    dto.setReviewImages(
        images.stream()
            .map(ReviewImage::getImageUrl)
            .toList()
    );

    return dto;
  }


}
