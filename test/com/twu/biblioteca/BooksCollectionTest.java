package com.twu.biblioteca;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static junit.framework.TestCase.assertEquals;

/**
 * Created by wmartins on 6/9/15.
 */
public class BooksCollectionTest {
    final PrintStream stdout = System.out;
    final ByteArrayOutputStream output = new ByteArrayOutputStream();
    Users users = new Users();
    BooksCollection books = new BooksCollection(users.getLibrary());
    @Before
    public void setUp() throws Exception {
        System.setOut(new PrintStream(output, true, "UTF-8"));

    }

    @Test
    public void testPrint(){

        books.print();
        assertEquals("Bible               Jesus               0\nNeuromancer         Willian Gibson      1980\n",output.toString() );

    }



    @After
    public void tearDown() throws Exception {
        System.setOut(stdout);
    }


}