package com.omkashyap.com.backend.controller;

import com.omkashyap.com.backend.dto.requestDto.AddressRequestDto;
import com.omkashyap.com.backend.dto.responseDto.AllAddressResponseDto;
import com.omkashyap.com.backend.dto.responseDto.ReviewResponseDto;
import com.omkashyap.com.backend.dto.responseDto.UserResponseDto;
import com.omkashyap.com.backend.service.AddressService;
import com.omkashyap.com.backend.service.ReviewService;
import com.omkashyap.com.backend.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequiredArgsConstructor
@RequestMapping("/user")
public class UserController {

  private final UserService userService;
  private final ReviewService reviewService;

  @GetMapping("/{userId}")
  ResponseEntity<UserResponseDto> getUserById(@PathVariable("userId") String userId) {
    return ResponseEntity.status(HttpStatus.OK).body(userService.getUserById(userId));
  }

  @PatchMapping("/{userId}")
  ResponseEntity<UserResponseDto> updatePartialUserDetail(@PathVariable String userId, @RequestBody Map<String, Object> updates) {
    return ResponseEntity.status(HttpStatus.OK).body(userService.updatePartialUserDetails(userId, updates));
  }

  @DeleteMapping("/{userId}")
  ResponseEntity<Void> deleteUserByUserId(@PathVariable String userId) {
    userService.deleteUserById(userId);
    return ResponseEntity.noContent().build();
  }

  @PostMapping("/{userId}/address")
  ResponseEntity<UserResponseDto> createAddressByUserId(@PathVariable String userId, @RequestBody AddressRequestDto addressRequestDto) {
    return ResponseEntity.status(HttpStatus.CREATED).body(userService.addAddressToUser(userId, addressRequestDto));
  }

  @GetMapping("/{userId}/address")
  ResponseEntity<List<AllAddressResponseDto>> getAddressByUserId(@PathVariable String userId) {
    return ResponseEntity.status(HttpStatus.OK).body(userService.getAllAddressByUserId(userId));
  }

  @GetMapping("/{userId}/all-reviews")
  ResponseEntity<List<ReviewResponseDto>> getAllReviewByUserId(@PathVariable String userId) {
    return ResponseEntity.status(HttpStatus.OK).body(reviewService.getAllReviewsByUserId(userId));
  }
}