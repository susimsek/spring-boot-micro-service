package com.spring.micro.service.impl;

import com.spring.micro.client.AccountServiceClient;
import com.spring.micro.dto.AccountDto;
import com.spring.micro.dto.TicketDto;
import com.spring.micro.model.PriorityType;
import com.spring.micro.model.Ticket;
import com.spring.micro.model.TicketStatus;
import com.spring.micro.model.es.TicketModel;
import com.spring.micro.repository.TicketRepository;
import com.spring.micro.repository.es.TicketElasticRepository;
import com.spring.micro.service.TicketNotificationService;
import com.spring.micro.service.TicketService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

//service client kütüphanesini ekleyerek account service istek attık
//Feign client round robin çalışır
@Service
@RequiredArgsConstructor
public class TicketServiceImpl implements TicketService {

    //ticket elastic repo çağrıldı
    private final TicketElasticRepository ticketElasticRepository;
    //ticket  repo çağrıldı
    private final TicketRepository ticketRepository;

    private final TicketNotificationService ticketNotificationService;

    //account service client çağrıldı
    private final AccountServiceClient accountServiceClient;

    @Transactional
    @Override
    public TicketDto save(TicketDto ticketDto) {
        Ticket ticket = new Ticket();

        //account servise istek atıldı
        ResponseEntity<AccountDto> accountDtoResponseEntity= accountServiceClient.get(ticketDto.getAssignee());
        String fullname=accountDtoResponseEntity.getBody().getNameAndSurname();//ad ve soyad alındı

        if(ticketDto.getDescription()==null)
            throw new IllegalArgumentException("Description boş olamaz");
        ticket.setDescription(ticketDto.getDescription());
        ticket.setNotes(ticketDto.getNotes());
        ticket.setTicketDate(ticketDto.getTicketDate());
        //enumarationunu döndürdük
        ticket.setTicketStatus(TicketStatus.valueOf(ticketDto.getTicketStatus()));
        ticket.setPriorityType(PriorityType.valueOf(ticketDto.getPriorityType()));
        ticket.setAssignee(fullname);
        ticket=ticketRepository.save(ticket);

        //Ticket modeli builder ile oluşturduk
        TicketModel model = TicketModel.builder()
                .description(ticket.getDescription())
                .notes(ticket.getNotes())
                .id(ticket.getId())
                .assignee(fullname)
                .priorityType(ticket.getPriorityType().getLabel())
                .ticketStatus(ticket.getTicketStatus().getLabel())
                .ticketDate(ticket.getTicketDate()).build();

        //elastic searcheye kaydedildi
        ticketElasticRepository.save(model);

        ticketDto.setId(ticket.getId());

        //kuyruğa notifikasyonu yaz
        ticketNotificationService.sendToQueue(ticket);

        return ticketDto;
    }

    @Override
    public TicketDto update(String ticketId,TicketDto ticketDto) {
        return null;
    }

    @Override
    public TicketDto getById(String ticketId) {
        return null;
    }

    @Override
    public Page<TicketDto> getPagination(Pageable pageable) {
        return null;
    }
}
