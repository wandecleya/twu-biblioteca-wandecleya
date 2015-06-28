package com.twu.biblioteca.view;

import com.twu.biblioteca.service.BooksCollection;
import com.twu.biblioteca.service.MoviesCollection;
import com.twu.biblioteca.service.Users;

import java.util.Scanner;

public class BibliotecaApp {


    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        Users users = new Users();
        BooksCollection books = new BooksCollection(users.getLibrary());
        MoviesCollection movies = new MoviesCollection(users.getLibrary());

        Interactions interactions = new Interactions(books, movies, users);
        interactions.welcome();

        int option;

        do{
            System.out.println(interactions.MAIN_MENU);
            option = in.nextInt();
            interactions.selectorMenu(option);


        } while((option != 4));

    }





}
