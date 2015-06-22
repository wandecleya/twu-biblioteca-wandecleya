package com.twu.biblioteca;

import com.twu.biblioteca.service.BooksCollection;
import com.twu.biblioteca.service.MoviesCollection;
import com.twu.biblioteca.service.Users;

import java.util.Scanner;

/**
 * Created by wmartins on 6/8/15.
 */
public class Interactions {

    Scanner in = new Scanner(System.in);

    BooksCollection books;
    MoviesCollection movies;
    private UserInteractions userInteractions;



    private ItemsInteractions itemsInteractions = new ItemsInteractions();
    User currentUser;//Represents the user currently logged in
    User libraryUser;//This user represents the Biblioteca

    private final String MOVIE = "movie";
    private final String BOOK = "book";

    public final String WELCOME = "*Welcome to Biblioteca*";

    private final String INVALID_OPTION = "Select a valid option!";
    private final String EXIT= "Thank you, bye!";

    public final String USER_MENU = "USER MENU\n" +
            "[1]Books List\n" +
            "[2]Movies List\n" +
            "[3]CheckOut Book\n" +
            "[4]Return book\n" +
            "[5]CheckOut Movie\n" +
            "[6]Return Movie\n" +
            "[7]My Profile\n" +
            "[8]Logout";

    public final String LIBRARIAN_MENU = "LIBRARIAN MENU\n" +
            "[1]Books List\n" +
            "[2]Movies List\n" +
            "[3]CheckOut Book\n" +
            "[4]Return book\n" +
            "[5]CheckOut Movie\n" +
            "[6]Return Movie\n" +
            "[7]Movie Details\n" +
            "[8]Book Details\n" +
            "[9]Logout\n";

    public final String MAIN_MENU = "MENU\n" +
            "[1]Books List\n" +
            "[2]Movies List\n" +
            "[3]Login\n" +
            "[4]Quit\n";

    public Interactions (BooksCollection books, MoviesCollection movies, Users users){
        this.books = books;
        this.movies = movies;
        libraryUser = users.getLibrary();
        userInteractions = new UserInteractions(users);
    }

    public void getUserOption(User currentUser) {
        if(currentUser.isRegularUser()) {
            selectRegularUserOption();
        }
        else{
            selectLibrarianUserOption();
        }
    }

    public void selectRegularUserOption() {
        int option;
        do {
            System.out.println(USER_MENU);
            option = in.nextInt();
            selectorMenuUser(option);
        } while ((option != 8));
    }

    public void selectLibrarianUserOption() {
        int option;
        do {
            System.out.println(LIBRARIAN_MENU);
            option = in.nextInt();
            selectorMenuLibrarian(option);
        } while ((option != 9));
    }


    public void welcome(){
        System.out.println(WELCOME.toUpperCase() + "\n");
    }

    public void selectorMenuUser(int option){
        switch (option){
            case 1:
                System.out.println(books.toString());
                break;
            case 2:
                System.out.println(movies.toString());
                break;
            case 3:
                itemsInteractions.checkOut(books, BOOK, currentUser);
                break;
            case 4:
                itemsInteractions.returnInteraction(books, BOOK, libraryUser);
                break;
            case 5:
                itemsInteractions.checkOut(movies, MOVIE, currentUser);
                break;
            case 6:
                itemsInteractions.returnInteraction(movies, MOVIE, libraryUser);
                break;
            case 7:
                System.out.println(currentUser.toString());
                break;
            case 8:
                logout();
                break;
            default:
                System.out.println(INVALID_OPTION);

        }
    }

    private void logout() {
        currentUser = null;
    }


    public void selectorMenu(int option){
        switch (option){
            case 1: System.out.println(books.toString());
                break;
            case 2: System.out.println(movies.toString());
                break;
            case 3:
                this.currentUser = userInteractions.login();
                getUserOption(currentUser);
                break;
            case 4: System.out.println(EXIT);
                break;
            default: System.out.println(INVALID_OPTION);

        }
    }

    public void selectorMenuLibrarian(int option){
        switch (option){
            case 1:
                System.out.println(books.toString());
                break;
            case 2:
                System.out.println(movies.toString());
                break;
            case 3:
                itemsInteractions.checkOut(books, BOOK, currentUser);
                break;
            case 4:
                itemsInteractions.returnInteraction(books, BOOK, libraryUser);
                break;
            case 5:
                itemsInteractions.checkOut(movies, MOVIE, currentUser);
                break;
            case 6:
                itemsInteractions.returnInteraction(movies, MOVIE, libraryUser);
                break;
            case 7:
                itemsInteractions.showInteraction(movies);
                break;
            case 8:
                itemsInteractions.showInteraction(books);
                break;
            case 9:
                logout();
                break;
            default:
                System.out.println(INVALID_OPTION);
        }
    }


}
