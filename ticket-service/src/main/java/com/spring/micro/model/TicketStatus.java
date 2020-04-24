package com.spring.micro.model;

import lombok.Getter;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

//labellerinin atadık enumların
@Getter
@RequiredArgsConstructor
public enum TicketStatus {
    OPEN("Açık"),
    IN_PROGRESS("Üzerinde Çalışılıyor"),
    RESOLVED("Çözüldü"),
    CLOSED("Kapandı");

    @NonNull
    private String label;
}
