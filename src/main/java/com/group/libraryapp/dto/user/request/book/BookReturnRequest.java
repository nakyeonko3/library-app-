package com.group.libraryapp.dto.user.request.book;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class BookReturnRequest {
    private String userName;
    private String bookName;
}
