package com.omkashyap.com.backend.dto.requestDto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class SellerAccountRequestDto {

  @NotBlank(message = "Account number is required")
  @Size(min = 9, max = 18, message = "Account number must be between 9 and 18 digits")
  @Pattern(regexp = "^[0-9]+$", message = "Account number must contain only digits")
  private String accountNo;

  @NotBlank(message = "Bank name is required")
  @Size(min = 3, max = 100, message = "Bank name is too short or too long")
  private String bankName;

  @NotBlank(message = "IFSC code is required")
  @Pattern(
      regexp = "^[A-Z]{4}0[A-Z0-9]{6}$",
      message = "Invalid IFSC format. Example: SBIN0123456"
  )
  private String ifscCode;
}
