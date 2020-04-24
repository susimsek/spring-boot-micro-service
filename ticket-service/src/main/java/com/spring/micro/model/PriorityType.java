package com.spring.micro.model;

import lombok.Getter;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

//labellerinin atadık enumların
@Getter
@RequiredArgsConstructor
public enum PriorityType {
    URGENT("Acil"),
    LOW("Önemsiz"),
    HIGH("Yüksek Öncelikli");

    @NonNull
    private String label;


}
