package com.kahyalar.selenium;

import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.io.IOException;

/**
 * Created by Furkan on 28.11.2016.
 */
public class screenshotTest {
    WebDriver driver;

    @Before
    public void warmUpEngine(){
        System.setProperty("webdriver.chrome.driver", "D:\\Belgeler\\WebDriver\\chromedriver.exe");
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("--start-maximized");
        driver = new ChromeDriver(chromeOptions);
    }

    @Test
    public void test() throws IOException {
        driver.get("http://www.n11.com");
        SeleniumScreenshot screenshot = new SeleniumScreenshot(driver);
        screenshot.getScreenshot(null, "C:\\Users\\Furkan Kahyalar\\Desktop\\");
    }
}
