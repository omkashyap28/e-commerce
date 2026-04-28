package com.omkashyap.com.backend.repository;

import com.omkashyap.com.backend.entity.WishList;
import org.springframework.data.jpa.repository.JpaRepository;

public interface WishListRepository extends JpaRepository<WishList, Long> {
}