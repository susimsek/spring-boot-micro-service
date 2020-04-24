package com.spring.micro.client;

import com.spring.micro.dto.AccountDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

//account-service ile eureka server üzerinden iletişim kuracak
@FeignClient("account-service")
public interface AccountServiceClient {

    //bu servise istek at
    @GetMapping("/api/v1/account/{id}")
    ResponseEntity<AccountDto> get(@PathVariable("id") String id);

}
