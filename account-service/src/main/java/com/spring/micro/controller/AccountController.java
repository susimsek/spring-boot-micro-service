package com.spring.micro.controller;


import com.spring.micro.dto.AccountDto;
import com.spring.micro.model.Account;
import com.spring.micro.service.AccountService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Slice;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


//@RequestMapping ile servislerimize path verdik
@RestController
@RequestMapping("/api/v1/account")
@RequiredArgsConstructor
public class AccountController {

    //account servisi çağırdık
    //constructor injeciton daha performanslı
    private final AccountService accountService;


    @GetMapping()
    public ResponseEntity<Slice<AccountDto>> getAll(Pageable pageable){
        return ResponseEntity.ok(accountService.findAll(pageable));//200 ile döndürdük
    }

    //{id} yi pathden aldık
    //@PathVariable("id") parametrenin idsini belirtitk
    @GetMapping("/{id}")
    public ResponseEntity<AccountDto> get(@PathVariable("id") String id){
        return ResponseEntity.ok(accountService.get(id));//200 ile döndürdük
    }

    //post isteği atılacak
    @PostMapping
    public ResponseEntity<AccountDto> save(@RequestBody AccountDto accountDto){
        return ResponseEntity.ok(accountService.save(accountDto));//200 ile döndürdük
    }

    //put isteği atılacak
    @PutMapping
    public ResponseEntity<AccountDto> update(@PathVariable String id,@RequestBody AccountDto accountDto){
        return ResponseEntity.ok(accountService.update(id,accountDto));//200 ile döndürdük
    }

    //delete isteği atılacak
    @DeleteMapping
    public ResponseEntity delete(@PathVariable String id){
        accountService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
