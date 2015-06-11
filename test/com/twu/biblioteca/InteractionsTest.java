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
    Interactions interactions = new Interactions ();
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
    public void testMenu() {

        interactions.menu();
        assertEquals("MENU\n[0]Quit\n[1]Books List\n[2]CheckOut Book\n[3]Return book\n[4]Movies List\n[5]CheckOut Movie\n", output.toString());
    }

    @Test
    public void testSelectorQuit(){
        interactions.selector(0);
        assertEquals("Thank you, bye!\n", output.toString());
    }

    @Test
    public void testSelectorInvalid(){
        interactions.selector(9);
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
