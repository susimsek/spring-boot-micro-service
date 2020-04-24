package com.spring.micro.config;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ModelMapperConfig {

    //model mapper beanı tanımlandı
    @Bean
    public ModelMapper modelMapper() {
        return new ModelMapper();
    }

}