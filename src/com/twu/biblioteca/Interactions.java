package com.twu.biblioteca;

/**
 * Created by wmartins on 6/8/15.
 */
public class Interactions {

    public static String welcome(String message){
        String result;
        result = "*" + message.toUpperCase() + "*";
        return result;
    }
}
