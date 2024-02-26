package com.group.fruitshopapp.repository;

import com.group.fruitshopapp.dto.FruitCreateRequest;
import com.group.fruitshopapp.dto.FruitGetStatResponse;
import com.group.fruitshopapp.dto.FruitUpdateRequest;
import org.springframework.web.bind.annotation.PutMapping;

import java.util.HashMap;
import java.util.Map;

public interface FruitRepository {
    public void createFruit(FruitCreateRequest request);

    public void updateFruit(FruitUpdateRequest request);

    public FruitGetStatResponse getStatOfFruit(String name);

    public boolean isFruitNotExist(FruitUpdateRequest request);

    public boolean isFruitNotExist(String name);
}
