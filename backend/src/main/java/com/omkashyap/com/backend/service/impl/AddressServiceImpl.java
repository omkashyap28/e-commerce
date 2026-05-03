package com.omkashyap.com.backend.service.impl;

import com.omkashyap.com.backend.repository.AddressRepository;
import com.omkashyap.com.backend.service.AddressService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AddressServiceImpl implements AddressService {

  private final AddressRepository addressRepository;

  @Override
  public void deleteAddressByUserId(String userId) {
    addressRepository.deleteByUser_UserId(userId);
  }
}
