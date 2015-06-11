package com.twu.biblioteca;

import java.util.Scanner;

/**
 * Created by wmartins on 6/8/15.
 */
public class Interactions {

    Scanner in = new Scanner(System.in);

    BooksCollection books = new BooksCollection();
    MoviesCollection movies = new MoviesCollection();




    public void welcome(String message){
        String result;
        result = "*" + message.toUpperCase() + "*\n";
        System.out.print(result);
    }

    public void menu (){
        String result = "MENU\n[0]Quit\n[1]Books List\n[2]CheckOut Book\n[3]Return book\n[4]Movies List\n[5]CheckOut Movie\n[6]Return Movie";
        System.out.println(result);
    }

    public void selector(int option){
        switch (option){
            case 0: System.out.println("Thank you, bye!");
                break;
            case 1: books.print();
                break;
            case 2: checkOutInteraction(books, "book");
                break;
            case 3: returnInteraction(books, "book");
                break;
            case 4: movies.print();
                break;
            case 5: checkOutInteraction(movies, "movie");
                break;
            case 6: returnInteraction(movies, "movie");
                break;
            default: System.out.println("Select a valid option!");

        }
    }

    public void returnInteraction (Collection item, String type){
        checkOutMessage();
        String name = in.next();
        if(item.returnItem(name)){
            System.out.println("Thank you for returning the " + type);
        }
        else {
            System.out.println("That is not a valid " + type + " to return.");
        }
    }

    public void checkOutMessage(){
        String result = "What is the title?";
        System.out.println(result);
    }


    public void checkOutInteraction(Collection item, String type){
        checkOutMessage();
        String name = in.nextLine();
        if(item.checkOut(name)){
            System.out.println("Thank you! Enjoy the " + type);
        }
        else{
            System.out.println("That " + type + " is not available");
        }
    }



}
