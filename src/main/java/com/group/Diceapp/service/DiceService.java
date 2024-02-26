package com.group.Diceapp.service;

<<<<<<< HEAD
import java.sql.Array;
=======
>>>>>>> origin/main
import java.util.Arrays;
import java.util.List;

public class DiceService {
<<<<<<< HEAD
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
=======
    public List<Integer> getDiceRollResults(int userInputNumer){
        int r1 = 0, r2 = 0, r3 = 0, r4 = 0, r5 = 0, r6 = 0;

        for (int i = 0; i < userInputNumer; i++) {
            double b = Math.random() * 6;
            if (b >= 0 && b < 1) {
                r1++;
            } else if (b >= 1 && b < 2) {
                r2++;
            } else if (b >= 2 && b < 3) {
                r3++;
            } else if (b >= 3 && b < 4) {
                r4++;
            } else if (b >= 4 && b < 5) {
                r5++;
            } else if (b >= 5 && b < 6) {
                r6++;
            }
        }
        return Arrays.asList(r1, r2, r3, r4, r5, r6);
    }

>>>>>>> origin/main
}
