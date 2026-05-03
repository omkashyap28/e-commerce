package com.omkashyap.com.backend.service;

import com.omkashyap.com.backend.dto.requestDto.LoginRequestDto;
import com.omkashyap.com.backend.dto.requestDto.SignUpRequestDto;
import com.omkashyap.com.backend.dto.responseDto.LoginResponseDto;
import com.omkashyap.com.backend.dto.responseDto.SignUpResponseDto;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import org.springframework.stereotype.Service;

import java.net.URI;

@Service
public interface AuthService {

  LoginResponseDto login(LoginRequestDto loginRequestDto);

  SignUpResponseDto signup(SignUpRequestDto signUpRequestDto);

  void logout(String token);
}
