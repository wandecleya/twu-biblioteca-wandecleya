package com.twu.biblioteca;

/**
 * Created by wmartins on 6/11/15.
 */
public class Item {
    private String title;
    private String author;
    private String year;
    private boolean available;

    public Item (String title, String author, String year){
        this.title = title;
        this.author = author;
        this.year = year;
        available = true;
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
}
