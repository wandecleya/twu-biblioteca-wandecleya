package com.twu.biblioteca;


import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class InteractionsTest {

    @Test
    public void testWelcome() {

        assertEquals("*WELCOME TO THE BIBLIOTECA*", Interactions.welcome("welcome to the biblioteca"));
    }


}
