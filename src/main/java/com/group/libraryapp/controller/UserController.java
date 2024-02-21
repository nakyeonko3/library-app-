package com.group.libraryapp.controller;

import com.group.libraryapp.domain.User;
import com.group.libraryapp.dto.user.request.UserCreateRequest;
import com.group.libraryapp.dto.user.response.UserResponse;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class UserController {

    List <User> users = new ArrayList<>();

    @PostMapping("/user")
    public void saveUser(@RequestBody UserCreateRequest request){
        users.add(new User(request.getAge(), request.getName()));
    }

    @GetMapping("/user")
    public List getUsers(){
        List <UserResponse> userResponses = new ArrayList<>();
        for (int i=0; i < users.size(); i++  ) {
            userResponses.add(new UserResponse(i, users.get(i)));
//            System.out.println(users.get(i).getName());
        }
        return userResponses;
    }

}
