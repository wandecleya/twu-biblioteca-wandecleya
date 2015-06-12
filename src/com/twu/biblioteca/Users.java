package com.twu.biblioteca;

import java.util.HashMap;

/**
 * Created by wmartins on 6/11/15.
 */
public class Users {
    HashMap<String, User> list;

    public Users(){
        list = new HashMap<String, User>();
        list.put("1", new User("1","123-4567"));
        list.put("2", new User("2","111-1111"));
    }

    public boolean isThere(String number){
        if(list.containsKey(number)){
            return true;
        }
        return false;
    }

    public User findUser(String number){
        return list.get(number);
    }
}
