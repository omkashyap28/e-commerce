package com.omkashyap.com.backend.service;

import com.omkashyap.com.backend.dto.requestDto.AddressRequestDto;
import com.omkashyap.com.backend.dto.responseDto.AllAddressResponseDto;
import com.omkashyap.com.backend.dto.responseDto.UserResponseDto;

import java.util.List;
import java.util.Map;

public interface UserService {
  UserResponseDto getUserById(String userId);

  UserResponseDto updatePartialUserDetails(String userId, Map<String, Object> updates);

  void deleteUserById(String userId);

  UserResponseDto addAddressToUser(String userId, AddressRequestDto addressRequestDto);

  List<AllAddressResponseDto> getAllAddressByUserId(String userId);
}
