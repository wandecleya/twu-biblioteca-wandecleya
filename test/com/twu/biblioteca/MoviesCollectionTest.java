package com.twu.biblioteca;

import com.twu.biblioteca.service.MoviesCollection;
import com.twu.biblioteca.service.Users;
import org.junit.Test;

import static junit.framework.TestCase.assertEquals;

/**
 * Created by wmartins on 6/11/15.
 */
public class MoviesCollectionTest {

    Users users = new Users();
    MoviesCollection movies = new MoviesCollection(users.getLibrary());

    @Test
    public void testToString()  {
       assertEquals("Fight Club          David Fincher       1999 0\nMatrix              Wacowskis           1999 0\n",movies.toString());
    }


}