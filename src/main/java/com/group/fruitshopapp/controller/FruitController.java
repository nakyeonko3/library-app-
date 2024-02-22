package com.group.fruitshopapp.controller;

import com.group.fruitshopapp.dto.FruitCreateRequest;
import com.group.fruitshopapp.dto.FruitGetStatResponse;
import com.group.fruitshopapp.dto.FruitUpdateRequest;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

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

    @GetMapping("/stat")
    public FruitGetStatResponse getStatOfFruit(@RequestParam String name) {
        // String format이라는 방법이 있는데 왜 안 썼을까?
// SELECT isSold, SUM(price) as SUM from fruit WHERE name = '사과' GROUP BY isSold;
//        String sql = String.format("SELECT isSold, SUM(price) as SUM from fruit WHERE name = %S GROUP BY isSold",name);
//        jdbcTemplate.update(sql);
        String sql = "SELECT isSold, SUM(price) as SUM from fruit WHERE name = ? GROUP BY isSold";

        Map<Boolean, Long> isSoldMap = new HashMap<>();
        jdbcTemplate.query(sql, (rs, rowNum) -> {
            boolean isSold = rs.getBoolean("isSold");
            long price = rs.getLong("SUM");
            isSoldMap.put(isSold, price);
            return 0;
        }, name);
        return new FruitGetStatResponse(isSoldMap.get(true), isSoldMap.get(false));
    }
// 추가적인 연산(예를 들자면 100개 이상인 과일 값들만 가져온다거나 가능하게 바꿔 보기

}
