package com.omkashyap.com.backend.controller;

import com.omkashyap.com.backend.dto.responseDto.ProductResponseDto;
import com.omkashyap.com.backend.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequiredArgsConstructor
@RequestMapping("/product")
public class ProductController {

  private final ProductService productService;

  @GetMapping("/{productId}")
  ResponseEntity<ProductResponseDto> getProductById(@PathVariable String productId) {
    return ResponseEntity.status(HttpStatus.OK).body(productService.getProductById(productId));
  }

}
