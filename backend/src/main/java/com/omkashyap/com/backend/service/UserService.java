package com.omkashyap.com.backend.service;

import com.omkashyap.com.backend.dto.responseDto.UserResponseDto;

import java.util.Map;

public interface UserService {
  UserResponseDto getUserById(String userId);

  UserResponseDto updatePartialUserDetails(String userId, Map<String, Object> updates);

  void deleteUserById(String userId);
}
