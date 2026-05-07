package com.omkashyap.com.backend.dto.requestDto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.Data;

@Data
public class SellerVerificationRequestDto {

  @NotBlank(message = "GST number is required")
  @Pattern(
      regexp = "^[0-9]{2}[A-Z]{5}[0-9]{4}[A-Z]{1}[1-9A-Z]{1}Z[0-9A-Z]{1}$",
      message = "Invalid GST number format"
  )
  private String gstNo; // Fixed typo from 'getNo'

  @NotBlank(message = "PAN number is required")
  @Pattern(
      regexp = "[A-Z]{5}[0-9]{4}[A-Z]{1}",
      message = "Invalid PAN number format"
  )
  private String panNo;
}