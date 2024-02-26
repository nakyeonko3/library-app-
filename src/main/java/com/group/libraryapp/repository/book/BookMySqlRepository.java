package com.group.libraryapp.repository.book;

import org.springframework.context.annotation.Primary;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Primary
@Repository
public class BookMySqlRepository implements BookRepository {
    JdbcTemplate jdbcTemplate;

    public BookMySqlRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public void saveBook(String name, Long price){
        String sql = "INSERT INTO books(name, price) values (?, ?)";
        jdbcTemplate.update(sql,name, price);

        String sqlread = "SELECT id, name, price FROM books";
        jdbcTemplate.query(sqlread,(rs, rowNum) -> {
            System.out.print("{name:"+rs.getString("name") +", price:"+ rs.getString("price")+ "}, ");
            return null;
        });
   }

}
