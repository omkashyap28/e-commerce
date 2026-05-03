package com.omkashyap.com.backend.service.impl;

import com.omkashyap.com.backend.dto.responseDto.UserAddressResponseDto;
import com.omkashyap.com.backend.dto.responseDto.UserResponseDto;
import com.omkashyap.com.backend.entity.Address;
import com.omkashyap.com.backend.entity.User;
import com.omkashyap.com.backend.repository.UserRepository;
import com.omkashyap.com.backend.service.UserService;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;

import org.modelmapper.ModelMapper;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.lang.Boolean;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

  private final UserRepository userRepository;
  private final ModelMapper modelMapper;
  private final PasswordEncoder passwordEncoder;

  @Override
  public UserResponseDto getUserById(String userId) {
    User user = userRepository.findByUserId(userId).orElseThrow(() -> new IllegalArgumentException("User not exists"));
    UserResponseDto res = modelMapper.map(user, UserResponseDto.class);

    List<UserAddressResponseDto> addresses = user.getAddresses()
        .stream()
        .map(address -> modelMapper.map(address, UserAddressResponseDto.class))
        .toList();

    res.setAddresses(addresses);

    return res;
  }

  @Override
  public UserResponseDto updatePartialUserDetails(String userId, Map<String, Object> updates) {
    User user = userRepository.findByUserId(userId).orElseThrow(() -> new IllegalArgumentException("User not exits with this userid"));

    updates.forEach((key, value) -> {
      switch (key) {
        case "firstName":
          user.setFirstName((String) value);
          break;
        case "lastName":
          user.setLastName((String) value);
          break;
        case "email":
          user.setEmail((String) value);
          break;
        case "contact":
          user.setContact((String) value);
          break;
        case "avatarUrl":
          user.setAvatarUrl((String) value);
          break;
        case "password":
          user.setPassword(passwordEncoder.encode((String) value));
          break;
        default:
          throw new IllegalArgumentException("Field not supported or not updatable");

      }
    });

    User updatedUser = userRepository.save(user);

    return modelMapper.map(updatedUser, UserResponseDto.class);
  }

  @Override
  @Transactional
  public void deleteUserById(String userId) {
    User user = userRepository.findByUserId(userId).orElseThrow(() -> new IllegalArgumentException("User not exists"));
    userRepository.delete(user);
  }
}
