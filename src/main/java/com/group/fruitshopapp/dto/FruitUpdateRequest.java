package com.group.fruitshopapp.dto;

import com.fasterxml.jackson.annotation.JsonCreator;
import lombok.Getter;

@Getter
public class FruitUpdateRequest {
    private final Long id;

    @JsonCreator
    public FruitUpdateRequest(Long id) {
        this.id = id;
    }
}
