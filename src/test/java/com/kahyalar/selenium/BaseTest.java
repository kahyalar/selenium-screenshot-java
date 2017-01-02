package com.kahyalar.selenium;

import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import java.io.File;

/**
 * Created by kahyalar on 01/01/2017.
 */
public class BaseTest{
    WebDriver driver;
    SeleniumScreenshot screenshot;
    private String filePath = System.getProperty("user.home")+"/Desktop/";
    private String testPage = "https://www.facebook.com/";
    private String defaultExtension = ".png";



    public boolean isScreenshotTaken(String fileName){
        File temp = new File(String.format("%s%s%s",filePath,fileName,defaultExtension));
        if(temp.exists() && !temp.isDirectory()) {
            return true;
        }
        else {
            return false;
        }
    }

    @Before
    public void warmUpEngine(){
        System.getProperty("user.home");
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("--start-maximized");
        driver = new ChromeDriver(chromeOptions);
        driver.get(testPage);
        screenshot = new SeleniumScreenshot(driver);
    }

    @After
    public void tearDown(){
        driver.quit();
    }
}
