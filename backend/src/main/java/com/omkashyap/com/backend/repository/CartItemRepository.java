package com.omkashyap.com.backend.repository;

import com.omkashyap.com.backend.entity.CartItem;
import org.springframework.data.jpa.repository.JpaRepository;


import java.util.List;

public interface CartItemRepository extends JpaRepository<CartItem, Long> {
  List<CartItem> findAllByCartId(Long cartId);

  void deleteByCartItemId(String cartItemId);
}