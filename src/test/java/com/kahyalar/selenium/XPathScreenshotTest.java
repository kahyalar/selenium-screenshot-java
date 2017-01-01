package com.kahyalar.selenium;

import org.junit.Test;

import java.io.IOException;

import static org.junit.Assert.assertTrue;

/**
 * Created by kahyalar on 01/01/2017.
 */
public class XPathScreenshotTest extends BaseTest {
    @Test
    public void test() throws IOException {
        screenshot.getScreenshotByXpath("merhaba",null, "//a[@class='logo']");

        assertTrue("merhaba is present via Xpath", isScreenshotTaken("merhaba"));
    }
}
