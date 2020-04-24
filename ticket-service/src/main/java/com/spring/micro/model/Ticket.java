package com.spring.micro.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.Date;

//base entiyden extend aldık
@Entity
//tablo adı verdik
@Table(name = "ticket")
@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = {"id"})
public class Ticket extends BaseEntity {

    //uuid auto generate etmesi için.32c karakter id üretir
    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(name = "UUID",strategy = "org.hibernate.id.UUIDGenerator")
    @Column(name = "id")
    private String id;

    @Column(name = "description",length = 600)
    private String description;

    @Column(name = "notes",length = 400)
    private String notes;

    @Column(name = "assignee",length = 50)
    private String assignee;

    @Column(name = "ticket_date")
    private Date ticketDate;

    //enumaration girilecek
    //default ordinal.databaseye 0,1,2 diye girer
    @Enumerated
    @Column(name = "priority_type")
    private PriorityType priorityType;

    //enumaration girilecek
    @Enumerated
    @Column(name = "ticket_status")
    private TicketStatus ticketStatus;


}
