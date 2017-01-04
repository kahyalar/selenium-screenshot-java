package com.kahyalar.selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.io.IOException;

import static org.junit.Assert.assertTrue;

/**
 * Created by kahyalar on 02/01/2017.
 */
public class Test extends BaseTest{
    @org.junit.Test
    public void fullScreenScreenshot() throws IOException {
        screenshot.takeFullSizeScreenShot(null, null);
    }

    @org.junit.Test
    public void webElementScreenshot() throws IOException {
        WebElement element = driver.findElement(By.xpath("//img[1]"));
        retinaScreenshot.getScreenshot("element", null, element);
    }
}
