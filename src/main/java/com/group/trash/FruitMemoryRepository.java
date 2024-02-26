//package com.group.trash;
//
//import java.util.ArrayList;
//import java.util.Date;
//import java.util.List;
//
//@Repository
//public class FruitMemoryRepository implements FruitRepository {
//    private final List<Fruit> fruits = new ArrayList<>();
//    private int nextId = 1;
//
//    @Override
//    public void createFruit(FruitCreateRequest request) {
//        Fruit fruit = new Fruit();
//        fruit.setId(nextId++);
//        fruit.setName(request.getName());
//        fruit.setWarehousingDate(request.getWarehousingDate());
//        fruit.setPrice(request.getPrice());
//        fruits.add(fruit);
//    }
//
//    @Override
//    public void updateFruit(FruitUpdateRequest request) {
//        Fruit fruit = findFruitById(request.getId());
//        if (fruit != null) {
//            fruit.setSold(true);
//        } else {
//            throw new IllegalArgumentException("Fruit with id " + request.getId() + " not found");
//        }
//    }
//
//    @Override
//    public FruitGetStatResponse getStatOfFruit(String name) {
//        long sumSold = 0;
//        long sumNotSold = 0;
//
//        for (Fruit fruit : fruits) {
//            if (fruit.getName().equals(name)) {
//                if (fruit.isSold()) {
//                    sumSold += fruit.getPrice();
//                } else {
//                    sumNotSold += fruit.getPrice();
//                }
//            }
//        }
//
//        return new FruitGetStatResponse(sumSold, sumNotSold);
//    }
//
//    @Override
//    public boolean isFruitNotExist(FruitUpdateRequest request) {
//        Fruit fruit = findFruitById(request.getId());
//        return fruit == null;
//    }
//
//    @Override
//    public boolean isFruitNotExist(String name) {
//        for (Fruit fruit : fruits) {
//            if (fruit.getName().equals(name)) {
//                return false;
//            }
//        }
//        return true;
//    }
//
//    private Fruit findFruitById(int id) {
//        for (Fruit fruit : fruits) {
//            if (fruit.getId() == id) {
//                return fruit;
//            }
//        }
//        return null;
//    }
//}
