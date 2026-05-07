package com.omkashyap.com.backend.dto.responseDto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ShopAddressResponseDto {

  private String address;

  private String street;

  private String city;

  private String state;

  private String postalCode;

  private String country;

}
