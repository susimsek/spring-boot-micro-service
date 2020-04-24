package com.spring.micro;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;

//circuit breaker için aktif ettik.isteğin sistemi gelmesini engeller
//servislerde oluşan yükü api gatewayde
///actuator adresinden http://localhost:8088/actuator/hystrix.stream datayı hystrix dashboarda girdik
@EnableHystrix
@SpringBootApplication
public class GatewayServerApplication {

    public static void main(String[] args) {
        SpringApplication.run(GatewayServerApplication.class, args);
    }

}
