package com.group.fruitshopapp.domain;

import lombok.*;

import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Fruit {
    private Long id;
    private String name;
    private LocalDate warehousingDate;
    private long price;
    private boolean isSold;
}
