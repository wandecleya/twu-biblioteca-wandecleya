package com.twu.biblioteca;

import com.twu.biblioteca.service.Users;

import java.util.Scanner;

/**
 * Created by wmartins on 6/18/15.
 */
public class UserInteractions {
    Users users;

    public UserInteractions (Users users){

        this.users = users;
    }

    Scanner in = new Scanner(System.in);

    private final String GET_REGISTRATION_NUMBER = "Type your registration number:";
    private final String GET_PASSWORD = "Type your password:";
    private final String USER_NOT_FOUND = "User not existent";
    private final String WRONG_PASSWORD = "Wrong Password";

    public User login(){
        String registrationNumber = question(GET_REGISTRATION_NUMBER);

        User currentUser = null;
        if(users.isResgistrationNumberValid(registrationNumber)){
            String password = question(GET_PASSWORD);
            currentUser = users.findUser(registrationNumber);

            if(currentUser.checkPassword(password)){
                return currentUser;
            } else{
                System.out.println(WRONG_PASSWORD);
            }
        } else {
            System.out.println(USER_NOT_FOUND);
        }
        return currentUser;
    }

    private String question(String message){
        System.out.println(message);
        String input = in.nextLine();
        return input;
    }

}
