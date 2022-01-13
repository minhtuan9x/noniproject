package com.laptrinhjavaweb.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.text.DecimalFormat;

@Configuration
public class DecimalFormatConfig {
    @Bean
    public DecimalFormat decimalFormat(){
        return new DecimalFormat("###,###");
    }
}
