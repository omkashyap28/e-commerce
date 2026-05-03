package com.omkashyap.com.backend.dto.responseDto;

import lombok.*;

@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class SignUpResponseDto {

  private String userId;

  private String email;

  private String message;
}
