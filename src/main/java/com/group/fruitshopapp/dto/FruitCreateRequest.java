package com.group.fruitshopapp.dto;

import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;

public class FruitCreateRequest {
    private final String name;
    private final LocalDate warehousingDate;
    private final long price;

    public FruitCreateRequest(String name, @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)LocalDate localDate, long price) {
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
