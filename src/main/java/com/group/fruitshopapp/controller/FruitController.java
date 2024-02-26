package com.group.fruitshopapp.controller;

import com.group.fruitshopapp.dto.FruitCreateRequest;
import com.group.fruitshopapp.dto.FruitGetStatResponse;
import com.group.fruitshopapp.dto.FruitUpdateRequest;
import com.group.fruitshopapp.service.FruitService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/fruit")
public class FruitController {
    private final FruitService fruitService;

    public FruitController(FruitService fruitService) {
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
