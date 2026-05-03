package com.omkashyap.com.backend.repository;

import com.omkashyap.com.backend.entity.Address;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AddressRepository extends JpaRepository<Address, Long> {
  List<Address> findByUser_UserId(String userId);

  void deleteByUser_UserId(String userId);
}