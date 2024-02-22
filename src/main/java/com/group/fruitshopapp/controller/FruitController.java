package com.group.fruitshopapp.controller;

import com.group.fruitshopapp.dto.FruitCreateRequest;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/fruit")
public class FruitController {

    private final JdbcTemplate jdbcTemplate;

    public FruitController(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @GetMapping("/test")
    public String testGet(@RequestParam String testMessage){
        return testMessage + " Hello, ";
    }

//    insert INTO fruit(name, warehousingDate, price)
//    VALUES ('사과',
//            STR_TO_DATE('2024-01-01', '%Y-%m-%d'),
//        1000);
    @PostMapping ()
    public void createFruit(@RequestBody FruitCreateRequest request){
        String sql = "INSERT INTO fruit(name, warehousingDate, price) VALUES (?,?,?)";
        jdbcTemplate.update(
                sql,request.getName(),
                request.getWarehousingDate(),
                request.getPrice());
    }
}
