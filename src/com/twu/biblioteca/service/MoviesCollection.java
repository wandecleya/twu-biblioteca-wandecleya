package com.twu.biblioteca.service;

import com.twu.biblioteca.Item;
import com.twu.biblioteca.Movie;
import com.twu.biblioteca.User;

import java.util.Map;

/**
 * Created by wmartins on 6/11/15.
 */
public class MoviesCollection extends Collection {



    public MoviesCollection (User owner){
        super();
        super.items.put("Matrix", new Movie("Matrix","Wacowskis", "1999", owner));
        super.items.put("Fight Club", new Movie("Fight Club", "David Fincher", "1999", owner));
    }

    public String toString(){
        String formatted = "";

        for(Map.Entry<String, Item> each: super.items.entrySet() ) {
            Movie movie = (Movie) each.getValue();
            if (movie.isAvailable()) {
                formatted += String.format("%-20s%-20s%s %s\n", movie.getTitle(), movie.getAuthor(), movie.getYear(), movie.getRating());

            }
        }

        return formatted;
    }
}
