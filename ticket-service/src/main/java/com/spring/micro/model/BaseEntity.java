package com.spring.micro.model;

import lombok.Data;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;
import java.io.Serializable;
import java.util.Date;

//@MappedSuperclass bu coloumnları kalıt
//createdBy session kullanıcıyı alır
@MappedSuperclass
public abstract class BaseEntity implements Serializable {

    //oluşturulma tarihini bu alana atar
    @CreatedDate
    @Column(name = "created_at")
    private Date createdAt;

    //güncelleme tarihini bu alana atar
    @LastModifiedDate
    @Column(name = "updated_at")
    private Date updatedAt;
}
