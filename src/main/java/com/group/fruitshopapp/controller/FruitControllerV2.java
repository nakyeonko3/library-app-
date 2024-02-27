package com.group.fruitshopapp.controller;


import com.group.fruitshopapp.dto.FruitCreateRequest;
import com.group.fruitshopapp.dto.FruitGetStatResponse;
import com.group.fruitshopapp.dto.FruitUpdateRequest;
import com.group.fruitshopapp.service.FruitServiceV2;
import org.springframework.context.annotation.Primary;
import org.springframework.web.bind.annotation.*;

@Primary
@RequestMapping("/api/v1/fruit")
@RestController
public class FruitControllerV2 {
    private FruitServiceV2 fruitServiceV2;

    public FruitControllerV2(FruitServiceV2 fruitServiceV2) {
        this.fruitServiceV2 = fruitServiceV2;
    }

    @PostMapping
    public void createFruit(@RequestBody FruitCreateRequest request) {
        fruitServiceV2.createFruit(request);
    }

    @PutMapping
    public void updateFruit(FruitUpdateRequest request) {
        fruitServiceV2.updateFruit(request);
    }

    @GetMapping("/stat")
    public FruitGetStatResponse getStatOfFruit(@RequestParam String name) {
        return fruitServiceV2.getStatOfFruit(name);
    }

}
