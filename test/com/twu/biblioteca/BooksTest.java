package com.twu.biblioteca;

import junit.framework.Assert;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static junit.framework.Assert.assertFalse;
import static junit.framework.TestCase.assertEquals;
import static junit.framework.TestCase.assertTrue;

/**
 * Created by wmartins on 6/9/15.
 */
public class BooksTest {
    final PrintStream stdout = System.out;
    final ByteArrayOutputStream output = new ByteArrayOutputStream();
    Books books = new Books();
    @Before
    public void setUp() throws Exception {
        System.setOut(new PrintStream(output, true, "UTF-8"));

    }

    @Test
    public void testPrint(){

        books.print();
        assertEquals("Bible               Jesus               0\nNeuromancer         Willian Gibson      1980\n",output.toString() );

    }

    @Test
    public void testIsThere(){
       assertTrue(books.isThere("Bible"));

        assertFalse(books.isThere("Book of Mormon"));
    }

    @Test
    public void testFindBook(){
        Assert.assertEquals("Jesus", books.findBook("Bible").getAuthor());
    }


    @Test
    public void testCheckOut(){
        assertTrue(books.checkOut("Bible"));
        assertFalse(books.checkOut("Book of Mormon"));

    }

    @Test
    public void testReturnBook(){
        books.checkOut("Bible");
        assertTrue(books.returnBook("Bible"));
        assertFalse(books.returnBook("Book of Mormon"));
    }

    @After
    public void tearDown() throws Exception {
        System.setOut(stdout);
    }


}