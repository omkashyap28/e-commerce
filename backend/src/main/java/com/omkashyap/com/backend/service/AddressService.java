package com.omkashyap.com.backend.service;

import org.springframework.stereotype.Service;

@Service

public interface AddressService {
  void deleteAddressByUserId(String userId);
}
