package com.group.trash;

import org.springframework.beans.factory.annotation.Qualifier;


public class NumberCounter {
    static Long number;

    public static Long idCounter(){
        return number++;
    }
}
