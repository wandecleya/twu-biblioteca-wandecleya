package com.twu.biblioteca;


import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.Assert.assertEquals;

public class InteractionsTest {
    final PrintStream stdout = System.out;
    final ByteArrayOutputStream output = new ByteArrayOutputStream();

    BooksCollection books = new BooksCollection();
    MoviesCollection movies = new MoviesCollection();

    Users users = new Users();
    Interactions interactions = new Interactions(books, movies, users);

    @Before
    public void setUp() throws Exception {
        System.setOut(new PrintStream(output, true, "UTF-8"));
    }


    @Test
    public void testWelcome() {
        interactions.welcome("welcome to the biblioteca");
        assertEquals("*WELCOME TO THE BIBLIOTECA*\n", output.toString());
    }

    @Test
    public void testMenuUser(){
        interactions.menuUser();
        assertEquals("USER MENU\n[1]Books List\n[2]Movies List\n[3]CheckOut Book\n[4]Return book\n[5]CheckOut Movie\n[6]Return Movie\n[7]Logout\n", output.toString());
    }
    @Test
    public void testMenu(){
        interactions.menu();
        assertEquals("MENU\n[1]Books List\n[2]Movies List\n[3]Login\n[4]Quit\n", output.toString());
    }

    @Test
    public void testSelectorQuit() {
        interactions.selectorMenu(4);
        assertEquals("Thank you, bye!\n", output.toString());
    }

    @Test
    public void testSelectorInvalid() {
        interactions.selectorMenu(10);
        assertEquals("Select a valid option!\n", output.toString());
    }

    @Test
    public void testselectorMenuUserInvalid() {
        interactions.selectorMenuUser(10);
        assertEquals("Select a valid option!\n", output.toString());
    }

    @Test
    public void testCheckOutMessage(){
        interactions.checkOutMessage();

        assertEquals("What is the title?\n", output.toString());
    }



    @After
    public void tearDown() throws Exception {
        System.setOut(stdout);

    }



}
