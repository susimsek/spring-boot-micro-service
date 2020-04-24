package com.spring.micro.queue;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class TicketNotification implements Serializable {

    private String ticketId;
    private String accountId;
    private String ticketDescription;
}
