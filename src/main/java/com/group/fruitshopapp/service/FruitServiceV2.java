package com.group.fruitshopapp.service;

import com.group.fruitshopapp.domain.Fruit;
import com.group.fruitshopapp.dto.FruitCreateRequest;
import com.group.fruitshopapp.dto.FruitGetStatResponse;
import com.group.fruitshopapp.dto.FruitUpdateRequest;
import com.group.fruitshopapp.repository.jpaRepo.FruitJpaRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FruitServiceV2 {
    private FruitJpaRepository fruitJpaRepository;

    public FruitServiceV2(FruitJpaRepository fruitJpaRepository) {
        this.fruitJpaRepository = fruitJpaRepository;
    }

    public void createFruit(FruitCreateRequest request) {
        Fruit fruit = fruitJpaRepository.save(new Fruit(request));
        System.out.println(fruit.getId() + ":" + fruit.getName());
    }

    public void updateFruit(FruitUpdateRequest request) {
        Fruit fruit = fruitJpaRepository.findById(request.getId())
                .orElseThrow(() -> new IllegalArgumentException(String.format("can't find name:%s", request.getId())));
        fruitJpaRepository.save(fruit);
    }

    public FruitGetStatResponse getStatOfFruit(String name) {

        List<Fruit>fruits = fruitJpaRepository.findAllByName(name);
        long salesAmount = 0L;
        long notSalseAmount = 0L;

        for (Fruit fruit1 : fruits) {
            if(fruit1.isSold()){
                salesAmount += fruit1.getPrice();
            } else {
                notSalseAmount += fruit1.getPrice();
            }
        }
        return new FruitGetStatResponse(salesAmount, notSalseAmount);
    }

}
