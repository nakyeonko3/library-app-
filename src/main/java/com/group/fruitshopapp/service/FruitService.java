package com.group.fruitshopapp.service;

import com.group.fruitshopapp.dto.FruitCreateRequest;
import com.group.fruitshopapp.dto.FruitGetStatResponse;
import com.group.fruitshopapp.dto.FruitUpdateRequest;
import com.group.fruitshopapp.repository.FruitMySqlRepository;
import com.group.fruitshopapp.repository.FruitRepository;
import org.springframework.stereotype.Service;

@Service
public class FruitService {

    private final FruitRepository fruitRepository;

    public FruitService(FruitRepository fruitRepository) {
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
