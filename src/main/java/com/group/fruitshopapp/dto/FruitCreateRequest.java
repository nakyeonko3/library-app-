package com.group.fruitshopapp.dto;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;


public class FruitCreateRequest {
    private final String name;
    private final LocalDate warehousingDate;
    private final long price;

    public FruitCreateRequest(String name, LocalDate localDate, long price) {
        this.name = name;
        this.warehousingDate = localDate;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public LocalDate getWarehousingDate() {
        return warehousingDate;
    }

    public long getPrice() {
        return price;
    }
}
