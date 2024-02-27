package com.group.fruitshopapp.dto.request;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.time.LocalDate;


@Getter
@RequiredArgsConstructor
public class FruitCreateRequest {
    private final String name;
    private final LocalDate warehousingDate;
    private final long price;
}
