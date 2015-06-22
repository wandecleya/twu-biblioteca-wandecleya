package com.twu.biblioteca;

import com.twu.biblioteca.service.BooksCollection;
import com.twu.biblioteca.service.Users;
import org.junit.Test;

import static junit.framework.TestCase.assertEquals;

/**
 * Created by wmartins on 6/9/15.
 */
public class BooksCollectionTest {

    Users users = new Users();
    BooksCollection books = new BooksCollection(users.getLibrary());

    @Test
    public void testToString(){
        assertEquals("Bible               Jesus               0\nNeuromancer         Willian Gibson      1980\n", books.toString() );
    }






}