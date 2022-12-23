package com.example.demo.config;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

import java.time.Duration;

@Configuration
public class RestTemplateConfig {

    private static final int TIMEOUT_MILLIS = 1000;

    @Bean
    @Qualifier("default")
    public RestTemplate restTemplate(){
        RestTemplateBuilder restTemplateBuilder = new RestTemplateBuilder();
        return restTemplateBuilder
                .setConnectTimeout(Duration.ofMillis(TIMEOUT_MILLIS))
                .setReadTimeout(Duration.ofMillis(TIMEOUT_MILLIS))
                .build();
    }
}
