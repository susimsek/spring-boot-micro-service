package com.spring.micro;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;

//Bir konfigurasyonu bu config server üzerinden çağırabiliyoruz.
@SpringBootApplication
@EnableConfigServer//Config serveri enable ettik.gitten yada pathden çekebiliyor.
public class ConfigServerApplication {

    public static void main(String[] args) {
        SpringApplication.run(ConfigServerApplication.class, args);
    }

}
