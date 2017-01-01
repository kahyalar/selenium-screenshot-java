package com.kahyalar.selenium;
import org.junit.Test;

import java.io.IOException;

import static org.junit.Assert.assertTrue;
/**
 * Created by kahyalar on 01/01/2017.
 */
public class ClassScreenshotTest extends BaseTest {
    @Test
    public void test() throws IOException {
        screenshot.getScreenshotByClassName("test",null,"searchBtn");

        assertTrue(isScreenshotTaken("test.png"));
    }
}
