package com.group.libraryapp.service.user;

import com.group.libraryapp.domain.User;
import com.group.libraryapp.dto.user.request.user.UserCreateRequest;
import com.group.libraryapp.dto.user.response.UserGetLoanHistoryResponse;
import com.group.libraryapp.dto.user.response.UserResponse;
import com.group.libraryapp.repository.book.UserLoanHistoryRepository;
import com.group.libraryapp.repository.user.UserRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserServiceV2 {

    private final UserRepository userRepository;
    private final UserLoanHistoryRepository userLoanHistoryRepository;

    public UserServiceV2(UserRepository userRepository, UserLoanHistoryRepository userLoanHistoryRepository) {
        this.userRepository = userRepository;
        this.userLoanHistoryRepository = userLoanHistoryRepository;
    }

    @Transactional
    public void saveUser(UserCreateRequest request) {
        userRepository.save(new User(request.getAge(), request.getName()));
    }

    @Transactional(readOnly = true)
    public List<UserResponse> getUsers() {
        return userRepository.findAll()
                .stream()
                .map(UserResponse::new)
                .collect(Collectors.toList());
    }

    @Transactional
    public void updateUser(Long id, String name) {
        User user = userRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException(String.format("can't find id %s", id)));
        user.updateName(name);
//        userRepository.save(user);
    }

    @Transactional
    public void deleteUser(String name) {
        userRepository.deleteByName(name);
    }

    @Transactional
    public List<UserResponse> getUsersByAge(int startage, int endage) {
        checkAgeVality(startage, startage);
        return userRepository.findByAgeBetween(startage, endage);
    }

    public void checkAgeVality(int startage, int endage) {
        if (startage < 0 || endage < 0) {
            throw new IllegalArgumentException();
        }
    }


    public List<UserGetLoanHistoryResponse> getUserLoanHistory(String name) {
//        이름을 이용해서 User 를 찾고
        User user = userRepository.findByName(name)
                .orElseThrow(IllegalArgumentException::new);
//        해당 User에 해당하는 반납기록을 가져와서 리턴한다.
        userLoanHistoryRepository.findAllByUserId(user.getId());
        return userLoanHistoryRepository.findAllByUserId(user.getId());
    }
}
