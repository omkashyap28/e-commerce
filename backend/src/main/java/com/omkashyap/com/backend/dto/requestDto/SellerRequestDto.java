package com.omkashyap.com.backend.dto.requestDto;

import com.omkashyap.com.backend.type.CategoryEnum;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class SellerRequestDto {
  @NotBlank(message = "User id is required")
  private String userId;

  @NotBlank(message = "Shop name is required")
  @Size(min = 5, max = 100)
  private String shopName;

  @Size(max = 200)
  private String description;

  @NotNull(message = "Shop category is required")
  private CategoryEnum category;


  private LocalDateTime createdAt;

}
