package com.twu.biblioteca;

import java.util.Scanner;

/**
 * Created by wmartins on 6/8/15.
 */
public class Interactions {

    Scanner in = new Scanner(System.in);

    BooksCollection books;
    MoviesCollection movies;
    Users users;
    User current;


    public Interactions (BooksCollection books, MoviesCollection movies, Users users){
        this.books = books;
        this.movies = movies;
        this.users = users;
    }

    private final String MOVIE = "movie";
    private final String BOOK = "book";


    public void welcome(String message){
        String result;
        result = "*" + message.toUpperCase() + "*\n";
        System.out.print(result);
    }



    public void login(){
        String textNumber = "Type your library number";
        String textPassword = "Type your password";
        String textNotFound = "User not existent";
        String textWrongPassword = "Wrong Password";


        System.out.println(textNumber);
        String number = in.next();

        if(users.isThere(number)){


            System.out.println(textPassword);
            String password = in.next();
            User user = users.findUser(number);

            if(user.checkPassword(password)){
                current = users.findUser(number);
                int option;

                do{
                    menuUser();
                    option = in.nextInt();
                    selectorMenuUser(option);


                } while((option != 7));

            }
            else{
                System.out.println(textWrongPassword);

            }
        }
        else {
            System.out.println(textNotFound);

        }




    }

    public void menu (){
        String result = "MENU\n[1]Books List\n[2]Movies List\n[3]Login\n[4]Quit";
        System.out.println(result);
    }

    public void menuUser(){
        String result= "USER MENU\n[1]Books List\n[2]Movies List\n[3]CheckOut Book\n[4]Return book\n[5]CheckOut Movie\n[6]Return Movie\n[7]Logout";

        System.out.println(result);
    }

    public void logout(){
        current = null;
    }

    public void selectorMenu(int option){
        switch (option){
            case 1: books.print();
                break;
            case 2: movies.print();
                break;
            case 3: login();
                break;
            case 4: System.out.println("Thank you, bye!");
                break;
            default: System.out.println("Select a valid option!");

        }
    }

    public void selectorMenuUser(int option){
        switch (option){
            case 1: books.print();
                break;
            case 2: movies.print();
                break;
            case 3: checkOutInteraction(books, BOOK);
                break;
            case 4: returnInteraction(books, BOOK);
                break;
            case 5: checkOutInteraction(movies, MOVIE);
                break;
            case 6: returnInteraction(movies, MOVIE);
                break;
            case 7: logout();
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
        in.nextLine();
        String name = in.nextLine();
        if(item.checkOut(name)){
            System.out.println("Thank you! Enjoy the " + type);
        }
        else{
            System.out.println("That " + type + " is not available");
        }
    }



}
