package com.omkashyap.com.backend.service.impl;

import com.omkashyap.com.backend.entity.Session;
import com.omkashyap.com.backend.entity.User;
import com.omkashyap.com.backend.repository.SessionRepository;
import com.omkashyap.com.backend.service.SessionService;
import com.omkashyap.com.backend.type.LoginProviderType;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
public class SessionServiceImpl implements SessionService {

  public final SessionRepository sessionRepository;

  @Override
  public void createSession(User user, String token, LocalDateTime expiresAt, String userAgent, String ipAddress, LoginProviderType provider) {
    Session session = Session.builder()
        .user(user)
        .accessToken(token)
        .expiresAt(expiresAt)
        .userAgent(userAgent)
        .ipAddress(ipAddress)
        .provider(provider)
        .active(true)
        .build();

    sessionRepository.save(session);
  }
}
