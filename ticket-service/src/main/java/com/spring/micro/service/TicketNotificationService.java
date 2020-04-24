package com.spring.micro.service;


import com.spring.micro.model.Ticket;

public interface TicketNotificationService {

    void sendToQueue(Ticket ticket);
}
