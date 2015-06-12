package com.twu.biblioteca;

import org.junit.Test;

import static junit.framework.Assert.assertFalse;
import static junit.framework.TestCase.assertTrue;

/**
 * Created by wmartins on 6/11/15.
 */
public class UserTest {
    User user = new User("Doe", "123-4567");

    @Test
    public void testCheckPassword() {
        assertTrue(user.checkPassword("123-4567"));
        assertFalse(user.checkPassword("000-0000"));
    }



}