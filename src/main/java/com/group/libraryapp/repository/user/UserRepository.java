package com.group.libraryapp.repository.user;

import com.group.libraryapp.dto.user.response.UserResponse;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

//@Repository
public class UserRepository {
    private final JdbcTemplate jdbcTemplate;

    public UserRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public void saveUser(int age, String name) {
        String sql = "INSERT INTO user(age, name) VALUES(?,?)";
        jdbcTemplate.update(sql, age, name);
    }
    public List<UserResponse> getUsers(){
        String sql = "SELECT * FROM user";
        return jdbcTemplate.query(sql, (rs, rowNum) -> {
            long id = rs.getLong("id");
            String name = rs.getString("name");
            int age = rs.getInt("age");
            return new UserResponse(id, name, age);
        });
    }

    public void updateUserName(String name, Long id) {
        String updateSql = "UPDATE user SET name = ? WHERE id =?";
        jdbcTemplate.update(updateSql, name, id);
    }

    public void deleteUserName(String name) {
        String deleteSql = "DELETE FROM user WHERE name =?";
        jdbcTemplate.update(deleteSql, name);
    }

    public boolean isUserNotExist(long id) {
        String readSql = "SELECT * FROM USER WHERE id = ?";
        return jdbcTemplate.query(readSql, (rs, rowNum) -> 0, id)
                .isEmpty();
    }

    public boolean isUserNotExist(String name) {
        String readSql = "SELECT * FROM USER WHERE name = ?";
        return jdbcTemplate.query(readSql, (rs, rowNum) -> 0, name)
                .isEmpty();
    }

    public static class BookRepository {
    }
}
