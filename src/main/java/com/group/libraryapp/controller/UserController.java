package com.group.libraryapp.controller;


import com.group.libraryapp.dto.user.request.user.UserCreateRequest;
import com.group.libraryapp.dto.user.request.user.UserUpdateRequest;
import com.group.libraryapp.dto.user.response.UserResponse;
import com.group.libraryapp.repository.book.UserLoanHistoryView;
import com.group.libraryapp.service.user.UserServiceV2;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/user")
@RestController
public class UserController {
    private final UserServiceV2 userServiceV2;

    public UserController(UserServiceV2 userService) {
        this.userServiceV2 = userService;
    }

    @PostMapping()
    public void saveUser(@RequestBody UserCreateRequest request) {
        userServiceV2.saveUser(request);
    }

    @GetMapping()
    public List<UserResponse> getUsers() {
        return userServiceV2.getUsers();
    }

    @GetMapping("/loanHistory")
    public List<UserLoanHistoryView> getLoanHistory(@RequestParam String name) {
        return userServiceV2.getUserLoanHistory(name);
    }

    @PutMapping()
    public void updateUser(@RequestBody UserUpdateRequest request) {
        userServiceV2.updateUser(request.getId(), request.getName());
    }

    @DeleteMapping()
    public void deleteUser(@RequestParam String name) {
        userServiceV2.deleteUser(name);
    }

//    @DeleteMapping("/loanHistory")
//    public void deleteUserHistory(@RequestParam String bookName) {
//        userServiceV2.deleteUserHistory(bookName);
//    }

    @GetMapping("/age")
    public List<UserResponse> getUsersByAge(@RequestParam int startage, @RequestParam int endage) {
        return userServiceV2.getUsersByAge(startage, endage);
    }


}