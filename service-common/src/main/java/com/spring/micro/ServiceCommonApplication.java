package com.spring.micro;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

//Feign Client Enable Oldu
@SpringBootApplication
@EnableFeignClients
public class ServiceCommonApplication {

    public static void main(String[] args) {
        SpringApplication.run(ServiceCommonApplication.class, args);
    }

}
