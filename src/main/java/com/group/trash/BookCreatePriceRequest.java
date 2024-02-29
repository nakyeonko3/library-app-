package com.group.trash;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class BookCreatePriceRequest {
    private final String name;
    private final Long price;
}
