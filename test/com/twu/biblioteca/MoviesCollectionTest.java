package com.twu.biblioteca;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static junit.framework.TestCase.assertEquals;

/**
 * Created by wmartins on 6/11/15.
 */
public class MoviesCollectionTest {
    final PrintStream stdout = System.out;
    final ByteArrayOutputStream output = new ByteArrayOutputStream();
    MoviesCollection movies = new MoviesCollection();

    @Before
    public void setUp() throws Exception {
        System.setOut(new PrintStream(output, true, "UTF-8"));

    }

    @Test
    public void testPrint()  {
        movies.print();
        assertEquals("Fight Club          David Fincher       1999 0\nMatrix              Wacowskis           1999 0\n",output.toString());
    }

    @After
    public void tearDown() throws Exception {
        System.setOut(stdout);
    }
}