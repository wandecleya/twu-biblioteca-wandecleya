package com.twu.biblioteca;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by wmartins on 6/8/15.
 */
public class Books {
    List<String> books;

    public Books(){
        books = new LinkedList<String>();
        books.add("Bible");
        books.add("Neuromancer");

    }

    public String showList(){
        String result = "";
        for(String each: books){
            result = result + each + "\n";
        }


        return result;
    }


}
