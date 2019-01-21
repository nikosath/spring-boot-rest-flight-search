package com.travix.medusa.busyflights.config;

import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class Config {

    private final RestTemplate restTemplateBean;

    Config(RestTemplateBuilder restTemplateBuilder) {
        restTemplateBean = restTemplateBuilder.build();
    }

    @Bean(name = "restTemplateBean")
    public RestTemplate prepareRestTemplateForProductService() {
        return restTemplateBean;
    }
}


