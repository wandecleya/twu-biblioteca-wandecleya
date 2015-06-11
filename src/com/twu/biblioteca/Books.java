package com.twu.biblioteca;

import java.util.*;

/**
 * Created by wmartins on 6/8/15.
 */
public class Books extends Collection {


    public Books(){
        super();
        super.items.put("Bible", new Book ("Bible","Jesus","0"));
        super.items.put("Neuromancer", new Book ("Neuromancer","Willian Gibson","1980"));
    }

    public void print(){



        for(Map.Entry<String, Object> each: super.items.entrySet() ){
            Book book = (Book) each.getValue();
            if(book.isAvailable()){
                System.out.printf("%-20s%-20s%s\n", book.getTitle(), book.getAuthor(), book.getYear());
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
        if(super.items.containsKey(title)){
            return true;
        }
        return false;
    }

    public Book findBook(String title){
        Book book = (Book) super.items.get(title);
        return book;
    }

    public boolean returnBook(String title){
        if(isThere(title)){
            findBook(title).setAvailable(true);
            return true;
        }

        return false;
    }





}
