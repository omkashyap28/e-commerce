package com.omkashyap.com.backend.dto.responseDto;

import lombok.Data;

import java.util.List;

@Data
public class CartItemResponseDto {

  private String cartItemId;
  private String productId;
  private Integer quantity;
  private List<ProductAttributeResponseDto> productAttributes;
  private String productUrl;

}
