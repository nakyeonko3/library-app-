package com.group.practiceLambda;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.function.Predicate;
import java.util.stream.Collectors;

class Fruit {
    static Integer couter = 0;
    private final int id;
    private final String name;
    private final int price;

    public Fruit(String name, int price) {
        this.id = ++couter;
        this.name = name;
        this.price = price;
    }


    public Integer getId() {
        return id;
    }

    public int getPrice() {
        return price;
    }

    public String getName() {
        return name;
    }
}

public class Main {
    public static void main(String[] args) {

        List<Fruit> fruits = Arrays.asList(new Fruit("사과", 1_000), new Fruit("사과", 1_200), new Fruit("사과", 1_200), new Fruit("사과", 1_500), new Fruit("바나나", 3_000), new Fruit("바나나", 3_200), new Fruit("바나나", 3_200), new Fruit("바나나", 2_500), new Fruit("수박", 10_900));

        // 사과와 수박 중에서 2000원 보다 비싼 것만 출력
        System.out.print("사과와 수박 중에서 2000원 보다 비싼 것들: {");
        System.out.print(new Main().filterFruits(fruits, fruit -> Arrays.asList("사과", "수박")
                        .contains(fruit.getName()) && fruit.getPrice() > 2_000)
                .stream()
                .map(fruit -> fruit.getId() + fruit.getName())
                .collect(Collectors.joining(", ")));
        System.out.println("}");

        // 수박과 바나나 합계 출력
        int sum = fruits.stream()
                .filter(fruit -> Arrays.asList("바나나", "수박")
                        .contains(fruit.getName()))
                .mapToInt(Fruit::getPrice)
                .sum();
        System.out.println("합계:" + sum);

//         수박과 바나나 중에서 가장 비싼 과일 출력
        Optional<Fruit> maxFruit = fruits.stream()
                .filter(fruit -> Arrays.asList("바나나", "수박")
                        .contains(fruit.getName()))
                .max(Comparator.comparingInt(Fruit::getPrice));

        maxFruit.ifPresent(fruit -> System.out.println("가장 비싼 과일: " + fruit.getName()));

    }

    private List<Fruit> filterFruits(List<Fruit> fruits, Predicate<Fruit> fruitFilter) {
        return fruits.stream()
                .filter(fruitFilter)
                .collect(Collectors.toList());
    }
}
