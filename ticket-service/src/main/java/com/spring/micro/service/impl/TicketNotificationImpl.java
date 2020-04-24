package com.spring.micro.service.impl;

import com.spring.micro.model.Ticket;
import com.spring.micro.queue.TicketNotification;
import com.spring.micro.service.TicketNotificationService;
import lombok.RequiredArgsConstructor;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.messaging.Source;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Service;

@Service
//gönderici olarak ayarladık
@EnableBinding(Source.class)
@RequiredArgsConstructor
public class TicketNotificationImpl implements TicketNotificationService {

    //sourceyi çağrıyor
    private final Source source;

    @Override
    public void sendToQueue(Ticket ticket) {
        TicketNotification ticketNotification=new TicketNotification();
        ticketNotification.setAccountId(ticket.getAssignee());
        ticketNotification.setTicketId(ticket.getId());
        ticketNotification.setTicketDescription(ticket.getDescription());

        //ticket notifikasyonu gönderdik
        source.output().send(MessageBuilder.withPayload(ticketNotification).build());
    }
}
