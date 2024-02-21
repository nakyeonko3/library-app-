package com.group.calculatorapp.dto.request;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;


public class CalculatorSumRequest {

    @JsonProperty("numbers")
    private List<Integer> numbers;

    public CalculatorSumRequest(){}

//    public NumbersSumRequest(List<Integer> numbers) {
//        this.numbers = numbers;
//    }

    public List<Integer> getNumbers() {
        return numbers;
    }
}
