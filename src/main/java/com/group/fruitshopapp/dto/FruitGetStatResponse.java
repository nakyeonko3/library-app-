package com.group.fruitshopapp.dto;

public class FruitGetStatResponse {
    private final Long salesAmount;
    private final Long notSalseAmount;

    public FruitGetStatResponse(Long salesAmount, Long notSalseAmount) {
        this.salesAmount = salesAmount;
        this.notSalseAmount = notSalseAmount;
    }

    public Long getNotSalseAmount() {
        return notSalseAmount;
    }

    public Long getSalesAmount() {
        return salesAmount;
    }
}
