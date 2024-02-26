package com.group.fruitshopapp.service;

import com.group.fruitshopapp.dto.FruitCreateRequest;
import com.group.fruitshopapp.dto.FruitGetStatResponse;
import com.group.fruitshopapp.dto.FruitUpdateRequest;
import com.group.fruitshopapp.repository.FruitMySqlRepository;
import org.springframework.stereotype.Service;

@Service
public class FruitService {

    private final FruitMySqlRepository fruitRepository;

    public FruitService(FruitMySqlRepository fruitRepository) {
        // 해당 id가 fruit 테이블 안에 존재하는지 검색하고 없다면 IllegalArgumentException 예외를 발생시킴

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
