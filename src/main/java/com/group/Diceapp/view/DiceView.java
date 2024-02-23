package com.group.Diceapp.view;

import com.group.Diceapp.controller.DiceController;

import java.util.List;

public class DiceView {
    public void diceRollResultView(){
        int[] diceRollResults =  new DiceController().getDiceNumber();
        for(int dicRollResult : diceRollResults){
            System.out.printf("%d은 %d번 나왔습니다, \n", dicRollResult+1, dicRollResult);
        }
    }
}
