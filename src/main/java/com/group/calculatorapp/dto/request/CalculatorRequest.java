package com.group.calculatorapp.dto.request;

public class CalculatorRequest {
    final private Integer num1;
    final private Integer num2;

    public CalculatorRequest(Integer num1, Integer num2) {
        this.num1 = num1;
        this.num2 = num2;
    }

    public Integer getNum1() {
        return num1;
    }

    public Integer getNum2() {
        return num2;
    }
}
