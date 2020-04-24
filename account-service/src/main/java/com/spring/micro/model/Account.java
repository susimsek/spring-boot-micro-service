package com.spring.micro.model;

import lombok.*;
import org.springframework.data.cassandra.core.mapping.Column;
import org.springframework.data.cassandra.core.mapping.PrimaryKey;
import org.springframework.data.cassandra.core.mapping.Table;

import java.io.Serializable;
import java.util.Date;
import java.util.UUID;

//tablo adını atadık
@Data
@NoArgsConstructor
@RequiredArgsConstructor
@EqualsAndHashCode(of = {"id"})
@Table(value = "accounts")
public class Account implements Serializable {

    //primary key belirledik
    //random id ürettik
    @PrimaryKey
    private String id = UUID.randomUUID().toString();

    @NonNull
    @Column(value = "uname")
    private String username;

    @NonNull
    @Column(value = "name")
    private String name;

    @NonNull
    @Column(value = "surname")
    private String surname;

    @NonNull
    @Column(value = "pwd")
    private String password;

    @NonNull
    @Column(value = "email")
    private String email;

    @NonNull
    @Column(value = "birth_date")
    private Date birthDate;

    @NonNull
    @Column(value = "active")
    private Boolean active;

    @Column(value = "created_at")
    private Date createdAt = new Date(System.currentTimeMillis());

}
