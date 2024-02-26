package com.group.libraryapp.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class BookResponse {
    final private String name;
    final private Integer price;
}
