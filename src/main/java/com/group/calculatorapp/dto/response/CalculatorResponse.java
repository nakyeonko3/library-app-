package com.group.calculatorapp.dto.response;

import com.group.calculatorapp.dto.request.CalculatorRequest;

public class CalculatorResponse {
    final private Integer add;
    final private Integer minus;
    final private Integer multiply;

    public CalculatorResponse(CalculatorRequest request) {
        this.add = request.getNum1() + request.getNum2();
        this.minus = request.getNum1() - request.getNum2();
        this.multiply = request.getNum1() * request.getNum2();
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
