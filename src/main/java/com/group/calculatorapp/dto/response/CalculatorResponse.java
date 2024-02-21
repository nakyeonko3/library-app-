package com.group.calculatorapp.dto.response;

public class CalculatorResponse {
    final private Integer add;
    final private Integer minus;
    final private Integer multiply;

    public CalculatorResponse(Integer addedResult, Integer minusedResult, Integer multipliedResult) {
        this.add = addedResult;
        this.minus = minusedResult;
        this.multiply = multipliedResult;
    }

    public Integer getAdd() {
        return add;
    }

    public Integer getMinus() {
        return minus;
    }

    public Integer getMultiply() {
        return multiply;
    }
}
