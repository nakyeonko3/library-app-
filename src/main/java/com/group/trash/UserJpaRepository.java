//package com.group.libraryapp.repository.user;
//
//
//import com.group.libraryapp.domain.User;
//import com.group.libraryapp.dto.user.response.UserResponse;
//import org.springframework.context.annotation.Primary;
//import org.springframework.data.domain.Example;
//import org.springframework.data.domain.Page;
//import org.springframework.data.domain.Pageable;
//import org.springframework.data.domain.Sort;
//import org.springframework.data.repository.query.FluentQuery;
//import org.springframework.stereotype.Repository;
//
//import java.util.List;
//import java.util.Optional;
//import java.util.function.Function;
//
//@Primary
//@Repository
//public class UserJpaRepository implements UserRepository{
//    public void saveUser(int age, String name) {
//
////        String sql = "INSERT INTO user(age, name) VALUES(?,?)";
////        jdbcTemplate.update(sql, age, name);
//    }
//
//    @Override
//    public List<UserResponse> getUsers() {
//        return null;
//    }
//
//    @Override
//    public void updateUserName(String name, Long id) {
//
//    }
//
//    @Override
//    public void deleteUserName(String name) {
//
//    }
//
//    @Override
//    public boolean isUserNotExist(long id) {
//        return false;
//    }
//
//    @Override
//    public boolean isUserNotExist(String name) {
//        return false;
//    }
//
//    }
//}
////@Repository
////public class UserJpaRepository implements UserRepository{
////
////}
