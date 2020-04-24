package com.spring.micro.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.UUID;

//password created-date,aktive kullanıcıya dönülmeyecek
//modeldeki fieldlar değiştiğinde,dto nesnesi kullanılarak cevap verilecek
@Data
@NoArgsConstructor
@AllArgsConstructor
public class AccountDto {

    private String id = UUID.randomUUID().toString();

    private String username;

    private String name;

    private String surname;

    private String email;

    private Date birthDate;

    public String getNameAndSurname(){
        return this.name+" "+ this.surname;
    }
}
