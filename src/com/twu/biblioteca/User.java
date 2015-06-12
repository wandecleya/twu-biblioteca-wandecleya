package com.twu.biblioteca;

/**
 * Created by wmartins on 6/11/15.
 */
public class User {
    private String password;
    private String number;

    public User (String number, String password){
        this.password = password;
        this.number = number;

    }

    public boolean checkPassword(String password){
        if(this.password.equals(password)){
            return true;
        }
        return false;
    }
}
