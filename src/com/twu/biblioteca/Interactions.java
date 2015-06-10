package com.twu.biblioteca;

import java.util.Scanner;

/**
 * Created by wmartins on 6/8/15.
 */
public class Interactions {

    Scanner in = new Scanner(System.in);
    Books books = new Books();

    public void welcome(String message){
        String result;
        result = "*" + message.toUpperCase() + "*\n";
        System.out.print(result);
    }

    public void menu (){
        String result = "MENU\n[0]Quit\n[1]Books List\n[2]Check out";
        System.out.println(result);
    }

    public void selector(int option){
        switch (option){
            case 0: System.out.println("Thank you, bye!");
                break;
            case 1: books.print();
                break;
            case 2: checkOutInteraction();
                break;
            default: System.out.println("Select a valid option!");

        }
    }

    public void checkOutMessage(){
        String result = "What is the title of the book?";
        System.out.println(result);
    }


    public void checkOutInteraction(){
        checkOutMessage();
        String name = in.next();
        if(books.checkOut(name)){
            System.out.println("Thank you! Enjoy the book");
        }
        else{
                  System.out.println("That book is not available");
        }
    }



}
