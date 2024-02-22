package com.group.fruitshopapp.controller;

import com.group.fruitshopapp.dto.FruitCreateRequest;
import com.group.fruitshopapp.dto.FruitUpdateRequest;
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
    public String testGet(@RequestParam String testMessage) {
        return testMessage + " Hello, ";
    }

    @PostMapping()
    public void createFruit(@RequestBody FruitCreateRequest request) {
        String sql = "INSERT INTO fruit(name, warehousingDate, price) VALUES (?,?,?)";
        jdbcTemplate.update(sql, request.getName(), request.getWarehousingDate(), request.getPrice());
    }

    @PutMapping
    public void updateFruit(@RequestBody FruitUpdateRequest request) {
        System.out.println(request.getId());

        // 해당 id가 fruit 테이블 안에 존재하는지 검색하고 없다면 IllegalArgumentException 예외를 발생시킴
        String sqlRead = "SELECT * FROM fruit WHERE id = ?";
        boolean isFruitNotExist = jdbcTemplate.query(sqlRead, (rs, rowNum) -> 0, request.getId())
                .isEmpty();
        if (isFruitNotExist) {
            throw new IllegalArgumentException();
        }

        String sqlUpdate = "UPDATE fruit SET isSold = True WHERE id = ?";
        jdbcTemplate.update(sqlUpdate, request.getId());
    }

    @GetMapping
    public void getStatOfFruit(@RequestParam String name){
        
    }
// 추가적인 연산(예를 들자면 100개 이상인 과일 값들만 가져온다거나 가능하게 바꿔 보기

}
