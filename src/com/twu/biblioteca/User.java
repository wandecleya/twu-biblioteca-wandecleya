package com.twu.biblioteca;

/**
 * Created by wmartins on 6/11/15.
 */
public class User {
    private String password;
    private String registration;
    private String type;
    private String name;
    private String email;
    private String phone;

    public User (){
        password = "";
        registration = "";
        type = "";
        name = "";
        email = "";
        phone = "";
    }

    public User (String registration, String password, String name, String email, String phone, String type ){
        this.password = password;
        this.registration = registration;
        this.type = type;
        this.name = name;
        this.email = email;
        this.phone = phone;

    }

    public boolean checkPassword(String password){
        if(this.password.equals(password)){
            return true;
        }
        return false;
    }

    public String getType(){
        return type;
    }

    public String toString(){
        String information = "Name: " + name + "\nEmail: " + email
                + "\nPhone: " + phone + "\nRegistration Number: " + registration
                + "\nUser Type: " + type;

        return information;
    }

}
