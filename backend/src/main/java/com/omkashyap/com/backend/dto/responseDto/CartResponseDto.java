package com.omkashyap.com.backend.dto.responseDto;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Builder
public class CartResponseDto {

  private Integer quantity;
  private LocalDateTime createdAt;

}
