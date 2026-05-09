package com.omkashyap.com.backend.dto.requestDto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;

@Data
@AllArgsConstructor
@Builder
public class ReviewRequestDto {

  private String userId;
  private Double rating;
  private String message;
  private List<String> reviewImages;
  private LocalDateTime createdAt;
}
