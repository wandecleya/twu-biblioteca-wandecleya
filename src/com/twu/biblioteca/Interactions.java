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

    User currentUser;//Represents the user currently logged in
    User libraryUser;//This user represents the Biblioteca

    private final String MOVIE = "movie";
    private final String BOOK = "book";

    private final String NORMAL = "Normal";

    public final String WELCOME = "*Welcome to Biblioteca*";

    private final String REGISTRATION = "Type your registration number:";
    private final String PASSWORD = "Type your password:";
    private final String NOTFOUND = "User not existent";
    private final String WRONGPASSWORD = "Wrong Password";
    private final String INVALIDOPTION = "Select a valid option!";
    private final String EXIT= "Thank you, bye!";
    private final String ASKTITLE= "What is the title?";

    public final String MAINMENU = "MENU\n" +
            "[1]Books List\n" +
            "[2]Movies List\n" +
            "[3]Login\n" +
            "[4]Quit\n";

    public final String LIBRARIANMENU = "LIBRARIAN MENU\n" +
            "[1]Books List\n" +
            "[2]Movies List\n" +
            "[3]CheckOut Book\n" +
            "[4]Return book\n" +
            "[5]CheckOut Movie\n" +
            "[6]Return Movie\n" +
            "[7]Movie Details\n" +
            "[8]Book Details\n" +
            "[9]Logout\n";

    public final String USERMENU = "USER MENU\n" +
            "[1]Books List\n" +
            "[2]Movies List\n" +
            "[3]CheckOut Book\n" +
            "[4]Return book\n" +
            "[5]CheckOut Movie\n" +
            "[6]Return Movie\n" +
            "[7]My Profile\n" +
            "[8]Logout";

    public Interactions (BooksCollection books, MoviesCollection movies, Users users){
        this.books = books;
        this.movies = movies;
        this.users = users;
        this.currentUser = null;
        libraryUser = users.getLibrary();
    }


    public void welcome(){
        System.out.println(WELCOME.toUpperCase() + "\n");
    }

    public void login(){

        System.out.println(REGISTRATION);
        String number = in.next();

        //Check if user has a valid registration number
        if(users.isThere(number)){

            System.out.println(PASSWORD);
            String password = in.next();
            User user = users.findUser(number);

            //Check if user entered a valid password
            if(user.checkPassword(password)){
                currentUser = users.findUser(number);
                int option;

                //Shows the Menu for logged users
                //Regular User
                if(currentUser.getType().equals(NORMAL)) {
                    do {

                        System.out.println(USERMENU);
                        option = in.nextInt();
                        selectorMenuUser(option);


                    } while ((option != 8));
                }
                //Librarian
                else{
                    do {
                        System.out.println(LIBRARIANMENU);
                        option = in.nextInt();
                        selectorMenuLibrarian(option);

                    } while ((option != 9));
                }

            }
            //Wrong Password
            else{
                System.out.println(WRONGPASSWORD);

            }
        }
        //Invalid Registration number
        else {
            System.out.println(NOTFOUND);

        }

    }



    public void logout(){
        currentUser = null;
    }

    public void selectorMenu(int option){
        switch (option){
            case 1: System.out.println(books.toString());
                break;
            case 2: System.out.println(movies.toString());
                break;
            case 3: login();
                break;
            case 4: System.out.println(EXIT);
                break;
            default: System.out.println(INVALIDOPTION);

        }
    }

    public void selectorMenuUser(int option){
        switch (option){
            case 1: System.out.println(books.toString());
                break;
            case 2: System.out.println(movies.toString());
                break;
            case 3: checkOutInteraction(books, BOOK);
                break;
            case 4: returnInteraction(books, BOOK);
                break;
            case 5: checkOutInteraction(movies, MOVIE);
                break;
            case 6: returnInteraction(movies, MOVIE);
                break;
            case 7: System.out.println(currentUser.toString());
                break;
            case 8: logout();
                break;
            default: System.out.println(INVALIDOPTION);

        }
    }

    public void selectorMenuLibrarian(int option){
        switch (option){
            case 1: System.out.println(movies.toString());
                break;
            case 2: System.out.println(movies.toString());
                break;
            case 3: checkOutInteraction(books, BOOK);
                break;
            case 4: returnInteraction(books, BOOK);
                break;
            case 5: checkOutInteraction(movies, MOVIE);
                break;
            case 6: returnInteraction(movies, MOVIE);
                break;
            case 7: showInteraction(movies);
                break;
            case 8: showInteraction(books);
                break;
            case 9: logout();
                break;
            default: System.out.println(INVALIDOPTION);

        }
    }

    public void showInteraction(Collection item){

        System.out.println(ASKTITLE);
        in.nextLine();
        String name = in.nextLine();

        String itemDetails = item.findItem(name).toString();

        System.out.println(itemDetails);

    }

    public void returnInteraction (Collection item, String type){

        System.out.println(ASKTITLE);
        in.nextLine();
        String name = in.nextLine();

        if(item.returnItem(name, libraryUser)){
            System.out.println("Thank you for returning the " + type);
        }
        else {
            System.out.println("That is not a valid " + type + " to return.");
        }
    }



    public void checkOutInteraction(Collection item, String type){

        System.out.println(ASKTITLE);
        in.nextLine();
        String name = in.nextLine();

        if(item.checkOut(name, currentUser)){
            System.out.println("Thank you! Enjoy the " + type);
        }
        else{
            System.out.println("That " + type + " is not available");
        }
    }



}
