package com.twu.biblioteca;

import java.util.*;

/**
 * Created by wmartins on 6/8/15.
 */
public class BooksCollection extends Collection {


    public BooksCollection(User owner){
        super();
        super.items.put("Bible", new Book ("Bible","Jesus","0", owner));
        super.items.put("Neuromancer", new Book ("Neuromancer","Willian Gibson","1980", owner));
    }

    public String toString(){
        String formatted = "";

        for(Map.Entry<String, Item> each: super.items.entrySet() ){
            Book book = (Book) each.getValue();
            if(book.isAvailable()){
                formatted += String.format("%-20s%-20s%s\n", book.getTitle(), book.getAuthor(), book.getYear());
            }

        }

        return formatted;

    }






}
