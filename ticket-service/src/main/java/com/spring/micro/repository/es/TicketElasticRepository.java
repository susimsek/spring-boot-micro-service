package com.spring.micro.repository.es;

import com.spring.micro.model.es.TicketModel;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

//repositort oluşturuldu
public interface TicketElasticRepository extends ElasticsearchRepository<TicketModel,String> {
}
