package com.twu.biblioteca;

import java.util.Scanner;

public class BibliotecaApp {


    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        Interactions interactions = new Interactions();
        interactions.welcome("Welcome to biblioteca");
        Books books = new Books();



        int option;

        do{
            interactions.menu();
            option = in.nextInt();
            interactions.selector(option);


        } while((option != 0));








    }





}
