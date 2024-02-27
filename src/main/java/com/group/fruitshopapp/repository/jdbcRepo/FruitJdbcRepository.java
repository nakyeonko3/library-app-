package com.group.fruitshopapp.repository.jdbcRepo;

import com.group.fruitshopapp.dto.request.FruitCreateRequest;
import com.group.fruitshopapp.dto.response.FruitGetStatResponse;
import com.group.fruitshopapp.dto.request.FruitUpdateRequest;

public interface FruitJdbcRepository {
    void createFruit(FruitCreateRequest request);

    void updateFruit(FruitUpdateRequest request);

    FruitGetStatResponse getStatOfFruit(String name);

    boolean isFruitNotExist(FruitUpdateRequest request);

    boolean isFruitNotExist(String name);
}
