package com.omkashyap.com.backend.dto.requestDto;

import lombok.Data;

import java.util.Map;

@Data
public class WishListRequestDto {

  private String productId;
  private Map<String, String> selectedAttributes;

}
