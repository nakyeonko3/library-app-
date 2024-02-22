package com.group.calculatorapp.controller;

import com.group.calculatorapp.dto.response.CalculatorResponse;
import com.group.calculatorapp.dto.response.CalculatorDayOfWeek;
import com.group.calculatorapp.dto.request.CalculatorRequest;
import com.group.calculatorapp.dto.request.CalculatorSumRequest;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;

import java.time.DayOfWeek;
import java.time.LocalDate;

//@RestController()
@RestController()
@RequestMapping("/api/v1")
public class CalculatorController {


    @GetMapping("/calc")
    public CalculatorResponse calculate(CalculatorRequest request) {
        return new CalculatorResponse(request);
    }

    @GetMapping("/day-of-the-week")
    public CalculatorDayOfWeek getDayofweek(@DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate date) {
        return new CalculatorDayOfWeek(date);
    }
//


    @PostMapping("/sum")
    public Integer sum(@RequestBody CalculatorSumRequest request){
        return request.getNumbers().stream().reduce(Integer::sum).get();
    }
}
