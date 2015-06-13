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
    Users users = new Users();
    BooksCollection books = new BooksCollection(users.getLibrary());
    User current = users.findUser("123-4567");

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
        assertTrue(books.checkOut("Bible", current));
        assertFalse(books.checkOut("Book of Mormon", current));

    }

    @Test
    public void testReturnBook(){
        books.checkOut("Bible", current);
        assertTrue(books.returnItem("Bible", current));
        assertFalse(books.returnItem("Book of Mormon", current));
    }

    @After
    public void tearDown() throws Exception {
        System.setOut(stdout);
    }



}