package com.group.fruitshopapp.dto.request;

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
