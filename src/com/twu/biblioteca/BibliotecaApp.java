package com.twu.biblioteca;

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
            System.out.println(interactions.MAINMENU);
            option = in.nextInt();
            interactions.selectorMenu(option);


        } while((option != 4));

    }





}
