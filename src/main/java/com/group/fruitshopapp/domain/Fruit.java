package com.group.fruitshopapp.domain;

import com.group.fruitshopapp.dto.request.FruitCreateRequest;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;

@Getter
@Setter
@Entity
public class Fruit {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 20)
    private String name;

    @Column(name="warehousing_date")
    private LocalDate warehousingDate;

    private long price;

    @Column(nullable = false)
    private boolean isSold= false;

    public Fruit() {
    }

    public Fruit(Long id, String name, LocalDate warehousingDate, long price, boolean isSold) {
        this.id = id;
        this.name = name;
        this.warehousingDate = warehousingDate;
        this.price = price;
        this.isSold = isSold;
    }

    public Fruit(String name, LocalDate warehousingDate, long price) {
        this.name = name;
        this.warehousingDate = warehousingDate;
        this.price = price;
    }

    public Fruit(FruitCreateRequest request) {
        this.name = request.getName();
        this.warehousingDate = request.getWarehousingDate();
        this.price = request.getPrice();
    }
}
