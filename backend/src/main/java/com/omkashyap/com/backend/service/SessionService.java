package com.omkashyap.com.backend.service;

import com.omkashyap.com.backend.entity.User;
import com.omkashyap.com.backend.type.LoginProviderType;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public interface SessionService {

  void createSession(User user, String token, LocalDateTime expiresAt, String userAgent, String ipAddress, LoginProviderType provider);

}
