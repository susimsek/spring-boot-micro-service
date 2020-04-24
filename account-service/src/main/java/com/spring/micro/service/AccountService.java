package com.spring.micro.service;


import com.spring.micro.dto.AccountDto;
import com.spring.micro.model.Account;
import com.spring.micro.repository.AccountRepository;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Slice;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

//kuyruktan ve veritabanından alıcak
//jvmde instanceyi tuttuk
//Component utilitylerde kullanılır.
//dto,business logic,apiler tamamen dto ile konuşacak.entity ile dto arasındaki dönüşümü servis katmanı yapar.
@Service
@RequiredArgsConstructor
public class AccountService {

    //account repository çağrıldı
    private final AccountRepository accountRepository;

    //model mapper çağrıldı
    private final ModelMapper modelMapper;

    public AccountDto get(String id){
        //bulursa datayı,bulamazsa hata fırlatır.
        Account account=accountRepository.findById(id).orElseThrow(() -> new IllegalArgumentException(id));
        //account objesi account dtoya map edildi
        return modelMapper.map(account,AccountDto.class);
    }

    @Transactional
    public AccountDto save(AccountDto accountDto){
        Account account = modelMapper.map(accountDto,Account.class);
        account = accountRepository.save(account);
        accountDto.setId(account.getId());
        return accountDto;
    }

    @Transactional
    public AccountDto update(String id,AccountDto accountDto){
        Account account=accountRepository.findById(id).orElseThrow(() -> new IllegalArgumentException(id));
        account.setBirthDate(accountDto.getBirthDate());
        account.setName(accountDto.getName());
        account.setSurname(accountDto.getUsername());

        accountRepository.save(account);

        return  modelMapper.map(account,AccountDto.class);
    }

    @Transactional
    public void delete(String id){

        Account account=accountRepository.findById(id).orElseThrow(() -> new IllegalArgumentException(id));
        if (account!=null){
            accountRepository.deleteById(id);
        }
    }

    public Slice<AccountDto> findAll(Pageable pageable) {
       Slice<Account> accounts=accountRepository.findAll(pageable);
       return null;
    }
}
