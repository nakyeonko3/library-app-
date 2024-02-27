package com.group.fruitshopapp.service;

import com.group.fruitshopapp.domain.Fruit;
import com.group.fruitshopapp.dto.request.FruitCreateRequest;
import com.group.fruitshopapp.dto.request.FruitGetPriceListRequest;
import com.group.fruitshopapp.dto.request.FruitUpdateRequest;
import com.group.fruitshopapp.dto.response.FruitGetCountResponse;
import com.group.fruitshopapp.dto.response.FruitGetStatResponse;
import com.group.fruitshopapp.repository.jpaRepo.FruitGetListProjection;
import com.group.fruitshopapp.repository.jpaRepo.FruitJpaRepository;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class FruitServiceV2 {
    final private FruitJpaRepository fruitJpaRepository;

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

        List<Fruit> fruits = fruitJpaRepository.findAllByName(name);
        long salesAmount = 0L;
        long notSalseAmount = 0L;

        for (Fruit fruit1 : fruits) {
            if (fruit1.isSold()) {
                salesAmount += fruit1.getPrice();
            } else {
                notSalseAmount += fruit1.getPrice();
            }
        }
        return new FruitGetStatResponse(salesAmount, notSalseAmount);
    }


    public FruitGetCountResponse getFruitsCountByIsSold(String name) {
        List<Fruit> fruits = fruitJpaRepository.findAllByName(name);
        long count = 0L;

        for (Fruit fruit1 : fruits) {
            if (fruit1.isSold()) {
                count++;
            }
        }
        return new FruitGetCountResponse(count);
    }

    public List<FruitGetListProjection> getFruitsPriceList(FruitGetPriceListRequest request) {
        if (request.getOption()
                .equals("GTE")) {
            return fruitJpaRepository.findAllByPriceGreaterThan(request.getPrice());
        } else if (request.getOption()
                .equals("LTE")) {
            return fruitJpaRepository.findAllByPriceLessThan(request.getPrice());
        } else {
            throw new IllegalArgumentException();
        }
    }
}
