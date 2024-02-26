package com.group.libraryapp.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class Book {
    final private String name;
    final private Long price;
}
