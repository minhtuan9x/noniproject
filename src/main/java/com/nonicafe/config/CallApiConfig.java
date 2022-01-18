package com.nonicafe.config;

import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Controller;
import org.springframework.web.client.RestTemplate;

@Controller
public class CallApiConfig {
    @Bean
    public RestTemplate restTemplate(){
        return new RestTemplate();
    }
}
