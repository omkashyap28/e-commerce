package com.omkashyap.com.backend.dtoMapper;

import com.omkashyap.com.backend.dto.responseDto.WishListResponseDto;
import com.omkashyap.com.backend.entity.WishListItem;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Component
@RequiredArgsConstructor
public class WishListDtoMapper {

  public WishListResponseDto mapToDto(WishListItem wishListItem) {
    WishListResponseDto responseDto = WishListResponseDto.builder()
        .wishlistId(wishListItem.getWishListItemId())
        .productId(wishListItem.getProduct().getProductId())
        .productUrl(wishListItem.getProduct().getProductUrl())
        .build();
    Map<String, String> productAttr = new HashMap<>();
    wishListItem.getProductAttributes().forEach(
        attr -> productAttr.put(
            attr.getAttributeName(),
            attr.getAttributeValue()
        )
    );
    responseDto.setProductAttributes(productAttr);

    return responseDto;
  }

}
