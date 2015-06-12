package com.twu.biblioteca;

import java.util.Map;

/**
 * Created by wmartins on 6/11/15.
 */
public class MoviesCollection extends Collection {



    public MoviesCollection (){
        super();
        super.items.put("Matrix", new Movie("Matrix","Wacowskis", "1999"));
        super.items.put("Fight Club", new Movie("Fight Club", "David Fincher", "1999"));
    }

    public void print(){
        for(Map.Entry<String, Item> each: super.items.entrySet() ){
            Movie movie = (Movie) each.getValue();
            if(movie.isAvailable()){
                System.out.printf("%-20s%-20s%s %s\n", movie.getTitle(), movie.getAuthor(), movie.getYear(), movie.getRating());
            }

        }


    }
}
