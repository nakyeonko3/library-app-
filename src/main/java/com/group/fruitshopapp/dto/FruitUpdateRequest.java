package com.group.fruitshopapp.dto;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.time.LocalDate;

public class FruitUpdateRequest {

    final private Long id;

    @JsonCreator
    public FruitUpdateRequest(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }
}
