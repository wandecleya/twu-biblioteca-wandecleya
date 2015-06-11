package com.twu.biblioteca;

/**
 * Created by wmartins on 6/11/15.
 */
public class Movie extends Item {
    private int rating;

    public Movie(String title, String author, String year){
        super(title, author, year);
        rating = 0;
    }

    public int getRating(){
        return rating;
    }


}
