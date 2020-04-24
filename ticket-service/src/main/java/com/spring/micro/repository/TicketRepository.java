package com.spring.micro.repository;

import com.spring.micro.model.Ticket;
import org.springframework.data.jpa.repository.JpaRepository;

//repository tanımlandı
//Spring boot 2 ve sornrasında @Repository anatasyonu gerekmiyor
public interface TicketRepository extends JpaRepository<Ticket,String> {
}
