package com.omkashyap.com.backend.dto.requestDto;

import com.omkashyap.com.backend.dto.responseDto.UserAddressResponseDto;
import jakarta.persistence.Column;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserAddressRequestDto {

  @NotBlank(message = "Address is required")
  private String address;

  @NotBlank(message = "Street number is required")
  private String street;

  @NotBlank(message = "City is required")
  private String city;

  @NotBlank(message = "State is required")
  private String state;

  @NotBlank(message = "Postal code is required")
  private String postalCode;

  @NotBlank(message = "Country is required")
  private String country;

  private Boolean isDefault;

}
