package com.group.fruitshopapp.controller;

import com.group.fruitshopapp.dto.FruitCreateRequest;
import com.group.fruitshopapp.dto.FruitGetStatResponse;
import com.group.fruitshopapp.dto.FruitUpdateRequest;
import com.group.fruitshopapp.service.FruitServiceV1;
import org.springframework.web.bind.annotation.*;

public interface FruitController {
    public void createFruit(FruitCreateRequest request);

    public void updateFruit(FruitUpdateRequest request) ;

    public FruitGetStatResponse getStatOfFruit(String name) ;
}

