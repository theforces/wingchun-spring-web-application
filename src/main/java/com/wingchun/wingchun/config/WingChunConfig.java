package com.wingchun.wingchun.config;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class WingChunConfig {

    @Bean
    public ModelMapper modelMapper() {
        return new ModelMapper();
    }
}
