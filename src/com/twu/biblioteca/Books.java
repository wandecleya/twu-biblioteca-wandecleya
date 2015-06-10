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
            if(each.isAvailable()){
                System.out.printf("%-20s%-20s%s\n",each.getTitle(), each.getAuthor(), each.getYear());
            }

        }



    }

    public boolean checkOut(String title){
        if(isThere(title)){
            findBook(title).setAvailable(false);
            return true;
        }
        return false;
    }

    public boolean isThere(String title){
        for(Book each: books){
            if(each.getTitle().equals(title)){
                return true;

            }
        }
        return false;
    }

    public Book findBook(String title){
        for(Book each: books){
            if(each.getTitle().equals(title)){
                return each;

            }
        }
        return null;
    }




}
