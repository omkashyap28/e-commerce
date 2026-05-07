package com.omkashyap.com.backend.controller;

import com.omkashyap.com.backend.dto.requestDto.AddressRequestDto;
import com.omkashyap.com.backend.dto.requestDto.SellerAccountRequestDto;
import com.omkashyap.com.backend.dto.requestDto.SellerVerificationRequestDto;
import com.omkashyap.com.backend.dto.responseDto.SellerResponseDto;
import com.omkashyap.com.backend.dto.responseDto.ShopAddressResponseDto;
import com.omkashyap.com.backend.service.SellerService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequiredArgsConstructor
@RequestMapping("/seller")
public class SellerController {

  private final SellerService sellerService;

  @GetMapping("/{sellerId}")
  ResponseEntity<SellerResponseDto> getSellerBySellerId(@PathVariable("sellerId") String sellerId) {
    return ResponseEntity.status(HttpStatus.OK).body(sellerService.getSellerBySellerId(sellerId));
  }

  @PostMapping("/{sellerId}/address")
  ResponseEntity<ShopAddressResponseDto> addShopAddressBySellerId(@PathVariable String sellerId, @RequestBody AddressRequestDto addressRequestDto) {
    return ResponseEntity.status(HttpStatus.CREATED).body(sellerService.addAddressBySellerId(sellerId, addressRequestDto));
  }

  @GetMapping("/{sellerId}/address")
  ResponseEntity<ShopAddressResponseDto> getShopAddressBySellerId(@PathVariable String sellerId) {
    return ResponseEntity.status(HttpStatus.OK).body(sellerService.getSellerAddressBySellerId(sellerId));
  }

  @PatchMapping("/{sellerId}")
  ResponseEntity<SellerResponseDto> updatePartialSellerDetail(@PathVariable String sellerId, @Valid @RequestBody Map<String, Object> updates) {
    return ResponseEntity.status(HttpStatus.OK).body(sellerService.updatePartialSellerDetails(sellerId, updates));
  }

  @PostMapping("/{sellerId}/verification")
  ResponseEntity<SellerResponseDto> addSellerVerification(@PathVariable String sellerId, @Valid @RequestBody SellerVerificationRequestDto requestDto) {
    return ResponseEntity.status(HttpStatus.CREATED).body(sellerService.addSellerVerification(sellerId, requestDto));
  }

  @PostMapping("/{sellerId}/account-verification")
  ResponseEntity<SellerResponseDto> addSellerAccountInfo(@PathVariable String sellerId, @Valid @RequestBody SellerAccountRequestDto requestDto) {
    return ResponseEntity.status(HttpStatus.CREATED).body(sellerService.addSellerAccountInfo(sellerId, requestDto));
  }

  @DeleteMapping("/{sellerId}")
  ResponseEntity<Void> deleteSeller(@PathVariable String sellerId) {
    sellerService.deleteSellerById(sellerId);
    return ResponseEntity.noContent().build();
  }

}
