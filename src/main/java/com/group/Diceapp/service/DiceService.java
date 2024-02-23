package com.group.Diceapp.service;

import java.sql.Array;
import java.util.Arrays;
import java.util.List;

public class DiceService {
    public int[] getDiceRollResults(int userInputNumer){

        if (userInputNumer < 1 || userInputNumer >6) {
            throw new IllegalArgumentException();
        }

        int[] rollCounts = new int[6];

        for (int i = 0; i < userInputNumer; i++) {
            int randomNumber = (int) (Math.random() * 6) + 1;
            rollCounts[randomNumber + 1]++;
        }

        return rollCounts;
    }
}
