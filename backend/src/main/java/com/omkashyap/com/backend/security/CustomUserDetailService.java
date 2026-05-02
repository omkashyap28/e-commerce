package com.omkashyap.com.backend.security;

import com.omkashyap.com.backend.entity.User;
import com.omkashyap.com.backend.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CustomUserDetailService implements UserDetailsService {

  private final UserRepository userRepository;

  public UserDetails loadUserByUsername(String email) {
    User user = userRepository.findByEmail(email)
        .orElseThrow(() ->
            new UsernameNotFoundException("User not exists")
        );

    return user;
//    return new org.springframework.security.core.userdetails.User(
//      user.getEmail(),
//      user.getPassword(),
//      List.of(new SimpleGrantedAuthority(user.getRoles().toString()))
//    );
  }
}
