package com.spring.micro.service;

import com.spring.micro.queue.TicketNotification;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.cloud.stream.messaging.Sink;
import org.springframework.stereotype.Service;

//bu anatasyonu kuyruğu dinlemesi için ekledik
//kuyruktan mesajı alıyor.
@EnableBinding(Sink.class)
public class NotificationListenerService {

    //kuyruğu dinliyor
    @StreamListener(Sink.INPUT)
    public void onNotification(TicketNotification ticketNotification) {
        System.out.println("notification alındı.Kullanıcıya gönderiliyor");
        System.out.println("Notification -> " + ticketNotification);
    }
}
