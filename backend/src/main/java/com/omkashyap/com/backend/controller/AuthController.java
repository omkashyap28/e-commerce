package com.omkashyap.com.backend.controller;

import com.omkashyap.com.backend.dto.requestDto.LoginRequestDto;
import com.omkashyap.com.backend.dto.requestDto.SellerRequestDto;
import com.omkashyap.com.backend.dto.requestDto.SignUpRequestDto;
import com.omkashyap.com.backend.dto.responseDto.LoginResponseDto;
import com.omkashyap.com.backend.dto.responseDto.SellerResponseDto;
import com.omkashyap.com.backend.dto.responseDto.SignUpResponseDto;
import com.omkashyap.com.backend.service.AuthService;
import com.omkashyap.com.backend.service.SellerService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/auth")
public class AuthController {

  private final AuthService authService;
  private final SellerService sellerService;

  @PostMapping("/login")
  ResponseEntity<LoginResponseDto> login(@RequestBody LoginRequestDto loginRequestDto) {
    return ResponseEntity.ok(authService.login(loginRequestDto));
  }

  @PostMapping("/signup")
  ResponseEntity<SignUpResponseDto> signup(@Valid @RequestBody SignUpRequestDto signUpRequestDto) {
    return ResponseEntity.status(HttpStatus.CREATED).body(authService.signup(signUpRequestDto));
  }

  @DeleteMapping("/logout")
  void logout(@RequestBody String token) {
    authService.logout(token);
  }


  @PostMapping("/seller/register")
  ResponseEntity<SellerResponseDto> registerSeller(@Valid @RequestBody SellerRequestDto requestDto) {
    return ResponseEntity.status(HttpStatus.CREATED).body(sellerService.registerSeller(requestDto));
  }

  @PostMapping("/seller/login")
  ResponseEntity<LoginResponseDto> loginSeller(@RequestBody SellerRequestDto requestDto) {
    return ResponseEntity.status(HttpStatus.CREATED).body(sellerService.loginSeller(requestDto));
  }

}
