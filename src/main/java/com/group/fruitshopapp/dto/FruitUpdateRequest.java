package com.group.fruitshopapp.dto;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.time.LocalDate;

public class FruitUpdateRequest {

    private Long id;

    public FruitUpdateRequest(){

    }
    public FruitUpdateRequest(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }
}
