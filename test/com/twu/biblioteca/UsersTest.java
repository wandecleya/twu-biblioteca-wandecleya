package com.twu.biblioteca;

import org.junit.Test;

import static junit.framework.TestCase.assertFalse;
import static junit.framework.TestCase.assertTrue;

/**
 * Created by wmartins on 6/11/15.
 */
public class UsersTest {
    Users users = new Users();
    @Test
    public void testIsThere(){
        assertTrue(users.isThere("1"));
        assertFalse(users.isThere("5"));

    }
}