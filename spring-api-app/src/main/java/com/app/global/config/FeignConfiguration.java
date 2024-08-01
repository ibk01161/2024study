package com.app.global.config;

import com.app.global.error.FeignClientExceptionErrorDecoder;
import feign.Logger;
import feign.Retryer;
import feign.codec.ErrorDecoder;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.cloud.openfeign.FeignClientsConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@EnableFeignClients(basePackages = "com.app")
@Import(FeignClientsConfiguration.class)                // Import 어노테이션 : Configuration 어노테이션으로 설정한 설정 파일을 두개 사용하는 경우
public class FeignConfiguration {

    // 로깅레벨 설정
    @Bean
    Logger.Level feignLoggerLevel() {
        return Logger.Level.FULL;
    }

    // 새로 생성한 FeignClientErrorDecoder 빈 등록 (에러 처리 정책)
    @Bean
    public ErrorDecoder errorDecoder() {
        return new FeignClientExceptionErrorDecoder();
    }

    // retry 설정 (재시도 정책)
    @Bean
    public Retryer retryer() {
        return new Retryer.Default(1000, 2000, 3);      // period : 실행 주기, maxAttempts : 최대 재시도 횟수
    }
}
