package com.group.fruitshopapp.service;

import com.group.fruitshopapp.dto.request.FruitCreateRequest;
import com.group.fruitshopapp.dto.request.FruitGetStatResponse;
import com.group.fruitshopapp.dto.request.FruitUpdateRequest;
import com.group.fruitshopapp.repository.jdbcRepo.FruitJdbcRepository;
import org.springframework.stereotype.Service;

@Service
public class FruitServiceV1 {

    private final FruitJdbcRepository fruitRepository;

    public FruitServiceV1(FruitJdbcRepository fruitRepository) {
        this.fruitRepository = fruitRepository;
    }

    public void createFruit(FruitCreateRequest request) {
        fruitRepository.createFruit(request);
    }

    public void updateFruit(FruitUpdateRequest request) {
        if (fruitRepository.isFruitNotExist(request)) {
            throw new IllegalArgumentException();
        }
        fruitRepository.updateFruit(request);
    }

    public FruitGetStatResponse getStatOfFruit(String name) {
        if (fruitRepository.isFruitNotExist(name)) {
            throw new IllegalArgumentException();
        }
        return fruitRepository.getStatOfFruit(name);
    }

}
