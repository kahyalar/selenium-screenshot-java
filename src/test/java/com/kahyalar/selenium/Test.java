package com.kahyalar.selenium;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.io.IOException;

import static org.junit.Assert.assertTrue;

/**
 * Created by kahyalar on 02/01/2017.
 */
public class Test extends BaseTest{
    @org.junit.Test
    public void test() throws IOException {
        WebElement googleLogo = driver.findElement(By.className("lfloat _ohe"));
        screenshot.getScreenshot("merhaba2", null, googleLogo);

        assertTrue("Merhaba has to be saved!", isScreenshotTaken("merhaba"));
    }

}
