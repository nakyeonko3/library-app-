package com.group.calculatorapp.controller;

import com.group.calculatorapp.dto.response.CalculatorResponse;
import com.group.calculatorapp.dto.response.CalculatorDayOfWeek;
import com.group.calculatorapp.dto.request.CalculatorRequest;
import com.group.calculatorapp.dto.request.CalculatorSumRequest;
import org.springframework.web.bind.annotation.*;

//@RestController()
@RestController()
@RequestMapping("/api/v1")
public class CalculatorController {

    @GetMapping("/calc")
    public CalculatorResponse calculate(CalculatorRequest request) {
        Integer add = request.getNum1() + request.getNum2();
        Integer minus = request.getNum1() - request.getNum2();
        Integer multiply = request.getNum1() * request.getNum2();
        return new CalculatorResponse(add, minus, multiply);
    }

    @GetMapping("/day-of-the-week")
    public CalculatorDayOfWeek getDayofweek(@RequestParam String date){
        return new CalculatorDayOfWeek(date);
    }

    @PostMapping("/sum")
    public Integer sum(@RequestBody CalculatorSumRequest request){
        return request.getNumbers().stream().reduce((a,b)->a+b).get();
    }
}
