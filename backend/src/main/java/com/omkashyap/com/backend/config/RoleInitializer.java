package com.omkashyap.com.backend.config;

import com.omkashyap.com.backend.entity.Role;
import com.omkashyap.com.backend.repository.RoleRepository;
import com.omkashyap.com.backend.type.RoleEnum;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@RequiredArgsConstructor
public class RoleInitializer {

  private final RoleRepository roleRepository;

  @Bean
  public CommandLineRunner initRoles() {
    return args -> {
      for (RoleEnum roleEnum : RoleEnum.values()) {
        roleRepository.findByRole(roleEnum)
            .orElseGet(() -> {
              Role role = Role.builder()
                  .role(roleEnum)
                  .build();
              return roleRepository.save(role);
            });
      }
      System.out.println("✅ Roles initialized");
    };
  }
}
