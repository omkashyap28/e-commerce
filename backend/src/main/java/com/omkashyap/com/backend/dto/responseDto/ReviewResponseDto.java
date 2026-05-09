package com.omkashyap.com.backend.dto.responseDto;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;

@Data
@NoArgsConstructor
public class ReviewResponseDto {

  private String reviewId;
  private Double rating;
  private String message;
  private List<String> reviewImages;
  private LocalDateTime createdAt;

}