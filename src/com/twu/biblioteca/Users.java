package com.twu.biblioteca;

import java.util.HashMap;

/**
 * Created by wmartins on 6/11/15.
 */
public class Users {
    private HashMap<String, User> list;
    private final String NORMAL = "Normal";
    private final String LIBRARIAN = "Librarian";
    private final String BIBLIOTECA = "Biblioteca";

    public Users(){
        list = new HashMap<String, User>();
        list.put("000-0000", new User("000-0000", "0", "Biblioteca", "b@a.c", "555-5555", BIBLIOTECA));//User that represents the Biblioteca.
        list.put("123-4567", new User("123-4567","1", "Camila", "e@r.c", "444-4444", NORMAL));
        list.put("111-1111", new User("111-1111","2", "Bibliotecaria", "r@.c", "333-3333", LIBRARIAN));
    }

    public boolean isResgistrationNumberValid(String registration){
        if(list.containsKey(registration)){
            return true;
        }
        return false;
    }

    public User findUser(String registration){
        return list.get(registration);
    }

    public User getLibrary(){
        return findUser("000-0000");
    }
}
