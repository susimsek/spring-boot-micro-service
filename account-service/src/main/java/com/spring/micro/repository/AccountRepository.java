package com.spring.micro.repository;


import com.spring.micro.model.Account;
import org.springframework.data.cassandra.repository.CassandraRepository;

//repository sınıf tasarlandı
public interface AccountRepository extends CassandraRepository<Account,String> {

}
