package com.twu.biblioteca.service;

import com.twu.biblioteca.controller.Item;
import com.twu.biblioteca.controller.User;

import java.util.HashMap;


/**
 * Created by wmartins on 6/11/15.
 */
public class Collection {
    HashMap<String, Item> items;
    User owner;


    public Collection (User owner){
        items = new HashMap<String, Item>();
        this.owner = owner;
    }

    private boolean isThere(String title){
        if(items.containsKey(title.toLowerCase())){
            return true;
        }
        return false;
    }

    public boolean checkOut(String title, User current){

        if(isThere(title)){
            Item item = findItem(title);
            item.setOwner(current);
            item.setAvailable(false);
            return true;
        }
        return false;
    }



    public Item findItem(String title){
        return items.get(title.toLowerCase());
    }

    public boolean returnItem(String title){
        if(isThere(title)){
            Item item = findItem(title);
            item.setOwner(owner);
            item.setAvailable(true);
            return true;
        }

        return false;
    }


}
