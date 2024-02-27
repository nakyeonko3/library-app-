package com.group.fruitshopapp.controller;

import com.group.fruitshopapp.dto.request.FruitCreateRequest;
import com.group.fruitshopapp.dto.request.FruitGetStatResponse;
import com.group.fruitshopapp.dto.request.FruitUpdateRequest;

public interface FruitController {
    public void createFruit(FruitCreateRequest request);

    public void updateFruit(FruitUpdateRequest request) ;

    public FruitGetStatResponse getStatOfFruit(String name) ;
}

