package com.group.Diceapp.service;


import java.sql.Array;

import java.util.Arrays;
import java.util.List;

public class DiceService {

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

}
