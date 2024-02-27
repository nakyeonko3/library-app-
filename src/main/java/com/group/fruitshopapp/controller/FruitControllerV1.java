package com.group.fruitshopapp.controller;

import com.group.fruitshopapp.dto.FruitCreateRequest;
import com.group.fruitshopapp.dto.FruitGetStatResponse;
import com.group.fruitshopapp.dto.FruitUpdateRequest;
import com.group.fruitshopapp.service.FruitServiceV1;
import org.springframework.web.bind.annotation.*;




//@RequestMapping("/api/v1/fruit")
//@RestController
public class FruitControllerV1 {
    private final FruitServiceV1 fruitService;

    public FruitControllerV1(FruitServiceV1 fruitService) {
        this.fruitService = fruitService;
    }

    @PostMapping
    public void createFruit(@RequestBody FruitCreateRequest request) {
        fruitService.createFruit(request);
    }

    @PutMapping
    public void updateFruit(@RequestBody FruitUpdateRequest request) {
        fruitService.updateFruit(request);
    }

    @GetMapping("/stat")
    public FruitGetStatResponse getStatOfFruit(@RequestParam String name) {
        return fruitService.getStatOfFruit(name);
    }
}
