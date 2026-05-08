package com.omkashyap.com.backend.dto.responseDto;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Map;

@Data
@NoArgsConstructor
public class ProductAttributeResponseDto {
  Map<String, String> attributes;
}
