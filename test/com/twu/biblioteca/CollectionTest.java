package com.twu.biblioteca;

import junit.framework.Assert;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static junit.framework.Assert.assertFalse;
import static junit.framework.TestCase.assertTrue;

/**
 * Created by wmartins on 6/11/15.
 */
public class CollectionTest {
    final PrintStream stdout = System.out;
    final ByteArrayOutputStream output = new ByteArrayOutputStream();
    BooksCollection books = new BooksCollection();

    @Before
    public void setUp() throws Exception {
        System.setOut(new PrintStream(output, true, "UTF-8"));

    }


    @Test
    public void testIsThere(){
        assertTrue(books.isThere("Bible"));

        assertFalse(books.isThere("Book of Mormon"));
    }

    @Test
    public void testFindBook(){
        Assert.assertEquals("Jesus", books.findItem("Bible").getAuthor());
    }


    @Test
    public void testCheckOut(){
        assertTrue(books.checkOut("Bible"));
        assertFalse(books.checkOut("Book of Mormon"));

    }

    @Test
    public void testReturnBook(){
        books.checkOut("Bible");
        assertTrue(books.returnItem("Bible"));
        assertFalse(books.returnItem("Book of Mormon"));
    }

    @After
    public void tearDown() throws Exception {
        System.setOut(stdout);
    }



}