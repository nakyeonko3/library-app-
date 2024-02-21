package practiceLambda;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

interface FruitFilter{
    boolean isSelected(Fruit fruit);
}

public class Main {
    public static void main(String[] args) {

        List<Fruit> fruits = Arrays.asList(
                new Fruit("사과", 1_000),
                new Fruit("사과", 1_200),
                new Fruit("사과", 1_200),
                new Fruit("사과", 1_500),
                new Fruit("바나나", 3_000),
                new Fruit("바나나", 3_200),
                new Fruit("바나나", 3_200),
                new Fruit("바나나", 2_500),
                new Fruit("수박", 10_900)
        );

        // ?
        // 필터 인터페이스 만들고
        // 해당 인터페이스 메서드를 익명클래스


//        new Main().findApples(fruits,"바나나").stream().forEach(a-> System.out.println("id:"+a.getId()+" 이름:"+a.getName() + " 가격:" + a.getPrice()));
//        System.out.println(new Main().findFruits(fruits, new FruitFilter() {
//            @Override
//            public boolean isSelected(Fruit fruit) {
//                return Arrays.asList("사과","바나나").contains(fruit.getName()) && fruit.getPrice()> 2_000;
//            }
//        }).stream().map(fruit -> fruit.getId()+fruit.getName()+", ").collect(Collectors.joining()));
        // map은 뭐고 collect는 뭘까?


//        System.out.println(new Main().filterFruit(fruits, fruit -> Arrays.asList("사과","수박").contains(fruit.getName())).stream().map(fruit -> fruit.getId()+fruit.getName() + ", ").collect(Collectors.joining()));
        System.out.println(new Main().filterFruit(fruits, fruit -> fruit.getPrice()>2_000).stream().map(fruit -> fruit.getId()).collect(Collectors.toList()));
//        System.out.println("김나성".contains("김나성"));
        System.out.println("Hello, world!");

    }

    private List<Fruit> filterFruit(List<Fruit> fruits, Predicate<Fruit> fruitFiler) {
        return fruits.stream().filter(fruitFiler).collect(Collectors.toList());
    }
}
