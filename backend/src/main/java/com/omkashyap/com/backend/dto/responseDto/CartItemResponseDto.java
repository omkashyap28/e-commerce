package com.omkashyap.com.backend.dto.responseDto;

import lombok.Data;

import java.util.Map;

@Data
public class CartItemResponseDto {

  private String cartItemId;
  private String productId;
  private Integer quantity;
  private Map<String, String> productAttributes;
  private String productUrl;

}
