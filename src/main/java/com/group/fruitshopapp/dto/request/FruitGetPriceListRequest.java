package com.group.fruitshopapp.dto.request;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public class FruitGetPriceListRequest {
    private final String option;
    private final Long price;
}
