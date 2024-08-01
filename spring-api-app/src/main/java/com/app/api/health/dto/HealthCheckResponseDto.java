package com.app.api.health.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@Getter @Builder
// 2024.08.01 FeignClient 테스트 중 기본 생성자 오류로 인해 어노테이션 추가
@AllArgsConstructor
@NoArgsConstructor
public class HealthCheckResponseDto {

    private String health;
    private List<String> activeProfiles;

}
