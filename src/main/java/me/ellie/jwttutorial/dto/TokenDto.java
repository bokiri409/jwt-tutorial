package me.ellie.jwttutorial.dto;

import lombok.*;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class TokenDto { // 토큰 정보를 Response할 때 사용

    private String token;
}