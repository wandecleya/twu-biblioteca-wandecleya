package com.twu.biblioteca;

import org.junit.Test;

import static junit.framework.TestCase.assertEquals;

/**
 * Created by wmartins on 6/9/15.
 */
public class BooksTest {

    @Test
    public void testBookList(){
        Books books = new Books();
        assertEquals("Bible\nNeuromancer\n", books.showList());

    }

}