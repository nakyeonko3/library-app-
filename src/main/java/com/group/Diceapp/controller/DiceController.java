package com.group.Diceapp.controller;

import com.group.Diceapp.service.DiceService;

import java.util.Scanner;

public class DiceController {
    public int[] getDiceNumber(){
        System.out.println("숫자를 입력하세요");
        Scanner scanner = new Scanner(System.in);
        int userInputNumer = scanner.nextInt();
        scanner.close();

        return new DiceService().getDiceRollResults(userInputNumer);
    }
}
