package com.group.libraryapp.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class BookCreateRequest {
    private final String name;
    private final Integer price;
}
