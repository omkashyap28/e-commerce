package com.omkashyap.com.backend.repository;

import com.omkashyap.com.backend.entity.WishList;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface WishListRepository extends JpaRepository<WishList, Long> {
  Optional<WishList> findByUser_UserId(String userId);
}