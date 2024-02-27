package com.group.fruitshopapp.repository.jdbcRepo;

import com.group.fruitshopapp.dto.request.FruitCreateRequest;
import com.group.fruitshopapp.dto.request.FruitGetStatResponse;
import com.group.fruitshopapp.dto.request.FruitUpdateRequest;

public interface FruitJdbcRepository {
    public void createFruit(FruitCreateRequest request);

    public void updateFruit(FruitUpdateRequest request);

    public FruitGetStatResponse getStatOfFruit(String name);

    public boolean isFruitNotExist(FruitUpdateRequest request);

    public boolean isFruitNotExist(String name);
}
