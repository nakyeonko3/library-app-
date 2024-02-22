package com.group.calculatorapp.dto.response;

import java.time.DayOfWeek;
import java.time.LocalDate;

public class CalculatorDayOfWeek {
    final private DayOfWeek dayOfTheWeek;

    public CalculatorDayOfWeek(LocalDate date) {
        this.dayOfTheWeek = date.getDayOfWeek();
    }

    public DayOfWeek getDayOfTheWeek() {
        return dayOfTheWeek;
    }
}
