package com.group.libraryapp.repository.user;

import com.group.libraryapp.domain.User;
import com.group.libraryapp.dto.user.response.UserResponse;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface UserRepository extends JpaRepository <User,Long>{
    Optional<User> findByName(String name);
    boolean existsByName(String name);
    List<UserResponse> findByAgeBetween(int startage, int endage);

    void deleteByName(String name);
}
