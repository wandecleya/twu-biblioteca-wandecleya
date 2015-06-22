package com.twu.biblioteca;


import com.twu.biblioteca.service.BooksCollection;
import com.twu.biblioteca.service.MoviesCollection;
import com.twu.biblioteca.service.Users;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.Assert.assertEquals;

public class InteractionsTest {
    final PrintStream stdout = System.out;
    final ByteArrayOutputStream output = new ByteArrayOutputStream();

    Users users = new Users();
    BooksCollection books = new BooksCollection(users.getLibrary());
    MoviesCollection movies = new MoviesCollection(users.getLibrary());


    Interactions interactions = new Interactions(books, movies, users);

    @Before
    public void setUp() throws Exception {
        System.setOut(new PrintStream(output, true, "UTF-8"));
    }

    @Test
    public void testWelcome() {
        interactions.welcome();
        assertEquals(interactions.WELCOME.toUpperCase()+"\n\n", output.toString());
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

    @After
    public void tearDown() throws Exception {
        System.setOut(stdout);

    }



}
