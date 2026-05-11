package com.omkashyap.com.backend.dto.responseDto;

import lombok.Builder;
import lombok.Data;

import java.util.Map;

@Data
@Builder
public class WishListResponseDto {

  private String wishlistId;
  private String productId;
  private String productUrl;
  private Map<String, String> productAttributes;

}
