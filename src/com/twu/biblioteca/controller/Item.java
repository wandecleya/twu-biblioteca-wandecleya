package com.twu.biblioteca.controller;

/**
 * Created by wmartins on 6/11/15.
 */
public class Item {
    private String title;
    private String author;
    private String year;
    private boolean available;
    private User owner;

    public Item (String title, String author, String year, User owner){
        this.title = title;
        this.author = author;
        this.year = year;
        available = true;
        this.owner = owner;
    }

    public String getTitle(){
        return title;
    }

    public String getAuthor(){
        return author;
    }

    public String getYear(){
        return year;
    }

    public boolean isAvailable(){
        return available;
    }

    public void setAvailable(boolean availability){
        available = availability;
    }

    public void setOwner (User owner){
        this.owner = owner;
    }

    public String toString(){
        String info = "Title: " + title + "\nAuthor: " + author + "\nYear: " + year + "\nOwner: \n" + owner.toString();
        return info;
    }
}
