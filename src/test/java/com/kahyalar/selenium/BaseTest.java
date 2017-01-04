package com.kahyalar.selenium;

import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import java.io.File;

/**
 * Created by kahyalar on 01/01/2017.
 */
public class BaseTest{
    WebDriver driver;
    SeleniumScreenshot screenshot;
    RetinaScreenshot retinaScreenshot;
    private String testPage = "https://www.facebook.com/";
    private static final String DEFAULT_FILE_PATH = System.getProperty("user.home")+"/Desktop/";
    private static final String DEFAULT_EXTENSION = ".png";

    public boolean isScreenshotTaken(String fileName){
        File temp = new File(String.format("%s%s%s",DEFAULT_FILE_PATH,fileName,DEFAULT_EXTENSION));
        if(temp.exists() && !temp.isDirectory()) {
            return true;
        }
        else {
            return false;
        }
    }

    @Before
    public void warmUp(){
        driver = new ChromeDriver();
        screenshot = new SeleniumScreenshot(driver);
        retinaScreenshot = new RetinaScreenshot(driver);
        driver.manage().window().setSize(new Dimension(1280, 800));
        driver.manage().window().setPosition(new Point(0, 0));
        driver.get(testPage);
    }

    @After
    public void tearDown(){
        driver.quit();
    }
}
