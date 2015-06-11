package com.twu.biblioteca;

import java.util.HashMap;


/**
 * Created by wmartins on 6/11/15.
 */
public class Collection {
    HashMap<String, Item> items;


    public Collection (){
        items = new HashMap<String, Item>();
    }

    public boolean isThere(String title){
        if(items.containsKey(title)){
            return true;
        }
        return false;
    }

    public boolean checkOut(String title){
        if(isThere(title)){
            findItem(title).setAvailable(false);
            return true;
        }
        return false;
    }



    public Item findItem(String title){
        return items.get(title);
    }

    public boolean returnItem(String title){
        if(isThere(title)){
            findItem(title).setAvailable(true);
            return true;
        }

        return false;
    }


}
