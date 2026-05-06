package com.omkashyap.com.backend.util;

import com.omkashyap.com.backend.type.LoginProviderType;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.stereotype.Service;


@Slf4j
@Service
@RequiredArgsConstructor
public class AuthUtil {

  public LoginProviderType getLoginProviderFromRegistrationId(String registrationId) {
    return switch (registrationId.toLowerCase()) {
      case "google" -> LoginProviderType.GOOGLE;
      default -> throw new IllegalArgumentException("Unsupported OAuth2 provider " + registrationId);
    };
  }

  public String determineProviderTypeFromOAuth2User(OAuth2User auth2User, String registrationId) {
    String providerId = switch (registrationId) {
      case "google" -> auth2User.getAttribute("sub");
      default -> {
        log.error("Unsupported provider type: {}", registrationId);
        throw new IllegalArgumentException("Unsupported provider type: " + registrationId);
      }
    };

    if (providerId == null || providerId.isBlank()) {
      log.error("Unable to determine providerId for provider {}", providerId);
      throw new IllegalArgumentException("Unable to determine providerId for provider " + providerId);
    }

    return providerId;
  }

}
