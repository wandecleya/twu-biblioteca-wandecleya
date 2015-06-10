package com.twu.biblioteca;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by wmartins on 6/8/15.
 */
public class Books {
    List<Book> books;

    public Books(){
        books = new LinkedList<Book>();
        books.add(new Book ("Bible","Jesus","0"));
        books.add(new Book ("Neuromancer","Willian Gibson","1980"));

    }

    public void print(){

        for(Book each: books){
            System.out.printf("%-20s%-20s%s\n",each.getTitle(), each.getAuthor(), each.getYear());
        }



    }


}
