package com.group.Diceapp.controller;

import com.group.Diceapp.service.DiceService;

<<<<<<< HEAD
import java.util.Scanner;

public class DiceController {
    public int[] getDiceNumber(){
=======
import java.util.List;
import java.util.Scanner;

public class DiceController {
    public List<Integer> getDiceNumber(){
>>>>>>> origin/main
        System.out.println("숫자를 입력하세요");
        Scanner scanner = new Scanner(System.in);
        int userInputNumer = scanner.nextInt();
        scanner.close();

        return new DiceService().getDiceRollResults(userInputNumer);
    }
}
