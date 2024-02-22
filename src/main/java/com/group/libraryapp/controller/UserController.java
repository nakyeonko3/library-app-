package com.group.libraryapp.controller;


import com.group.libraryapp.dto.user.request.UserCreateRequest;
import com.group.libraryapp.dto.user.request.UserUpdateRequest;
import com.group.libraryapp.dto.user.response.UserResponse;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserController {
    private final JdbcTemplate jdbcTemplate;

    public UserController(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @DeleteMapping("/user")
    public void deleteUser(@RequestParam String name) {
        String deleteSql = "DELETE FROM user WHERE name =?";
        jdbcTemplate.update(deleteSql, name);

//        String usersSql = "SELECT * FROM user";
//        jdbcTemplate.query(usersSql, (rs, rowNum) -> {
//            long id = rs.getLong("id");
//            String qname = rs.getString("name");
//            int age = rs.getInt("age");
//            System.out.println(age + id + name);
//            return new UserResponse(id, qname, age);
//        });
    }

    @PostMapping("/user")
    public void saveUser(@RequestBody UserCreateRequest request) {
        String sql = "INSERT INTO user(age, name) VALUES(?,?)";
        jdbcTemplate.update(sql, request.getAge(), request.getName());
//        users.add(new User(request.getAge(), request.getName()));

    }

    @GetMapping("/user")
    public List<UserResponse> getUsers() {
        String sql = "SELECT * FROM user";
        return jdbcTemplate.query(sql, (rs, rowNum) -> {
            long id = rs.getLong("id");
            String name = rs.getString("name");
            int age = rs.getInt("age");
            return new UserResponse(id, name, age);
        });
    }

    @PutMapping("/user")
    public void updateUser(@RequestBody UserUpdateRequest request) {
        String readSql = "SELECT * FROM USER WHERE id = ?";
        boolean isUserNotExist = jdbcTemplate.query(readSql, (rs, rowNum) -> 0, request.getId())
                .isEmpty();
        if (isUserNotExist) {
            throw new IllegalArgumentException();
        }

        String updateSql = "UPDATE user SET name = ? WHERE id =?";
        jdbcTemplate.update(updateSql, request.getName(), request.getId());

//        List<String> list = jdbcTemplate.query(readSql, (rs, rowNum) -> "id:" + rs.getInt("id") + ", name:" + rs.getString("name"), request.getId());
//        list.forEach(System.out::println);
    }

}