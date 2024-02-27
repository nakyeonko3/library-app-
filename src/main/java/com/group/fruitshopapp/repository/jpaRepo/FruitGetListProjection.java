package com.group.fruitshopapp.repository.jpaRepo;


import java.time.LocalDate;

public interface FruitGetListProjection {
     String getName();
     Long getPrice();
     LocalDate getWarehousingDate();
}
