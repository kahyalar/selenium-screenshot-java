package com.kahyalar.selenium;

import org.junit.Test;

import static org.junit.Assert.assertTrue;

/**
 * Created by kahyalar on 01/01/2017.
 */
public class HomeDirectoryTest extends BaseTest {
    @Test
    public void shouldSeeHomeDirectory(){
        String defaultFilePath = System.getProperty("user.home")+"/Desktop/";

        assertTrue(defaultFilePath.equals("/Users/kahyalar/Desktop/"));
    }
}
