package com.group.libraryapp.dto.user.request.book;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class BookGetResponse {
    private Long id;
    private String name;
}
