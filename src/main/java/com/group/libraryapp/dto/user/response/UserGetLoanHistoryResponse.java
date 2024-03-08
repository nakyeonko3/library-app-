package com.group.libraryapp.dto.user.response;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class UserGetLoanHistoryResponse {
    private String userName;
    private String bookName;
    private boolean isReturn;
}
