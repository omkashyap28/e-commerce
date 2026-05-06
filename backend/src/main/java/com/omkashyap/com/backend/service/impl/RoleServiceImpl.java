package com.omkashyap.com.backend.service.impl;

import com.omkashyap.com.backend.repository.RoleRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class RoleServiceImpl {

  private final RoleRepository roleRepository;

//  @Override
//  public Role addRole(RoleEnum roleEnum) {
//    return roleRepository.setRole(roleEnum);
//  }
}
