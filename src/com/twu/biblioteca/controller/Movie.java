package com.twu.biblioteca.controller;

/**
 * Created by wmartins on 6/11/15.
 */
public class Movie extends Item {
    private int rating;

    public Movie(String title, String author, String year, User owner){
        super(title, author, year, owner);
        rating = 0;
    }

    public int getRating(){
        return rating;
    }


}
