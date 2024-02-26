package com.group.fruitshopapp.repository;

import com.group.fruitshopapp.domain.Fruit;
import com.group.fruitshopapp.dto.FruitCreateRequest;
import com.group.fruitshopapp.dto.FruitGetStatResponse;
import com.group.fruitshopapp.dto.FruitUpdateRequest;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

//@Primary
@Repository
public class FruitMemoryRepository implements FruitRepository{
    private final List<Fruit> fruits = new ArrayList<>();
    private Long nextId = 1L;

    public FruitMemoryRepository() {

    }

    @Override
    public void createFruit(FruitCreateRequest request) {
        Fruit fruit = new Fruit();
        fruit.setId(nextId++);
        fruit.setName(request.getName());
        fruit.setWarehousingDate(request.getWarehousingDate());
        fruit.setPrice(request.getPrice());
        fruits.add(fruit);
     }

    @Override
    public void updateFruit(FruitUpdateRequest request) {
        Fruit fruit = findFruitById(request.getId());
        if (fruit != null) {
            fruit.setSold(true);
        } else {
            throw new IllegalArgumentException();
        }
    }

    @Override
    public FruitGetStatResponse getStatOfFruit(String name) {
        long sumSold = 0;
        long sumNotSold = 0;

        for (Fruit fruit : fruits) {
            if (fruit.getName().equals(name)) {
                if (fruit.isSold()) {
                    sumSold += fruit.getPrice();
                } else {
                    sumNotSold += fruit.getPrice();
                }
            }
        }

        return new FruitGetStatResponse(sumSold, sumNotSold);
    }

    @Override
    public boolean isFruitNotExist(FruitUpdateRequest request) {
        Fruit fruit = findFruitById(request.getId());
        return fruit == null;
    }
    @Override
    public boolean isFruitNotExist(String name) {
        for (Fruit fruit : fruits) {
            if (fruit.getName().equals(name)) {
                return false;
            }
        }
        return true;
    }
    private Fruit findFruitById(Long id) {
        for (Fruit fruit : fruits) {
            if (fruit.getId() == id) {
                return fruit;
            }
        }
        return null;
    }

}
