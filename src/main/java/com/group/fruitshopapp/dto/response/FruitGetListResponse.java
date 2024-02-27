package com.group.fruitshopapp.dto.response;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.time.LocalDate;

@Getter
@RequiredArgsConstructor
public class FruitGetListResponse {
    private final String name;
    private final Long price;
    private final LocalDate warehousingDate;
}
