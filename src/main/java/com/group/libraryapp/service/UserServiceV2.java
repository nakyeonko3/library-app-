package com.group.libraryapp.service;

import com.group.libraryapp.domain.User;
import com.group.libraryapp.dto.user.request.UserCreateRequest;
import com.group.libraryapp.dto.user.request.UserUpdateRequest;
import com.group.libraryapp.dto.user.response.UserResponse;
import com.group.libraryapp.repository.user.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserServiceV2 {

    private final UserRepository userRepository;
    public UserServiceV2(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public void saveUser(UserCreateRequest request){
        User user = userRepository.save(new User(
                request.getAge(),
                request.getName()
        ));
        System.out.println(user.getId());
    }

    public List<UserResponse> getUsers(){
        return userRepository.findAll().stream()
                .map(UserResponse::new)
                .collect(Collectors.toList());
    }

    public void updateUser(UserUpdateRequest request) {
        User user = userRepository.findById(request.getId())
                .orElseThrow(IllegalArgumentException::new);
        user.updateName(user.getName());
        userRepository.save(user);
    }

    public void deleteUser(String name) {
        User user = userRepository.findByName(name)
                .orElseThrow(IllegalArgumentException::new);
        userRepository.delete(user);
    }

    public List<UserResponse> getUsersByAge(int startage,int endage){
        checkAgeVality(startage, startage);
//        List<User> users = userRepository.findByAgeBetween(startage, endage);
//        System.out.println(users.stream().map(user -> user.getName()+":"+user.getAge()).collect(Collectors.joining(", ")));
        return userRepository.findByAgeBetween(startage, endage);
    }

    public void checkAgeVality(int startage, int endage){
        if(startage < 0 || endage < 0) {
            throw new IllegalArgumentException();
        }
    }


}
