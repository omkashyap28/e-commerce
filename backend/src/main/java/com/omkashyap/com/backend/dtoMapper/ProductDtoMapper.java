package com.omkashyap.com.backend.dtoMapper;

import com.omkashyap.com.backend.dto.responseDto.ProductAttributeResponseDto;
import com.omkashyap.com.backend.dto.responseDto.ProductImageResponseDto;
import com.omkashyap.com.backend.dto.responseDto.ProductResponseDto;
import com.omkashyap.com.backend.entity.Product;
import com.omkashyap.com.backend.entity.ProductAttribute;
import com.omkashyap.com.backend.entity.ProductImage;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component
public class ProductDtoMapper {

  public ProductResponseDto mapToDto(Product product) {
    ProductResponseDto dto = new ProductResponseDto();

    dto.setProductId(product.getProductId());
    dto.setDescription(product.getDescription());
    dto.setSellerId(product.getSeller().getSellerId());
    dto.setInStock(product.getInStock());
    dto.setTotalReviews(product.getTotalReviews());
    dto.setAverageRating(product.getAverageRating());
    dto.setPrice(product.getPrice());

    if (product.getCategory() != null) {
      dto.setCategoryId(product.getCategory().getId());
    }

    if (product.getProductImages() != null) {
      List<ProductImageResponseDto> productImageResponseDtos = product.getProductImages()
          .stream()
          .map(this::mapToProductImageResponseDto)
          .toList();

      dto.setProductImages(productImageResponseDtos);
    }

    if (product.getProductAttributes() != null) {

      List<ProductAttributeResponseDto> productAttributeResponseDtos =
          product.getProductAttributes()
              .stream()
              .map(this::mapToProductAttributeResponseDto)
              .toList();

      dto.setProductAttributes(productAttributeResponseDtos);
    }

    return dto;

  }

  private ProductImageResponseDto mapToProductImageResponseDto(ProductImage image) {

    ProductImageResponseDto dto = new ProductImageResponseDto();

    dto.setImageUrl(image.getImageUrl());

    return dto;
  }

  private ProductAttributeResponseDto mapToProductAttributeResponseDto(ProductAttribute attribute) {

    ProductAttributeResponseDto dto = new ProductAttributeResponseDto();

    Map<String, String> attributesMap = new HashMap<>();

    attributesMap.put(
        attribute.getAttributeName(),
        attribute.getAttributeValue()
    );

    dto.setAttributes(attributesMap);

    return dto;
  }
}
