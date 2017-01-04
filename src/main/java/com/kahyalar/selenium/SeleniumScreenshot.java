package com.kahyalar.selenium;

import org.openqa.selenium.*;
import org.openqa.selenium.Point;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import static javax.imageio.ImageIO.read;
import static javax.imageio.ImageIO.write;
import static org.apache.commons.io.FileUtils.*;

/**
 * Created by İlker Furkan KAHYALAR
 * Contact : furkankahyalar@gmail.com
 */

public class SeleniumScreenshot {
    protected File screenshot;
    protected File screenshotLocation;
    protected BufferedImage fullSizeImage;
    protected String fileName,filePath;
    protected String defaultFileName = "screenshot";
    protected String defaultFilePath = System.getProperty("user.home")+"/Desktop/";
    protected WebElement element;
    protected WebDriver driver;

    public SeleniumScreenshot(WebDriver driver){
        this.driver = driver;
    }

    private void checkNullFields(){
        if(fileName == null && filePath == null){
            screenshotLocation = new File(java.lang.String.format("%s%s.png",defaultFilePath, defaultFileName));
        }
        else if(fileName == null) {
            screenshotLocation = new File(java.lang.String.format("%s%s.png",filePath, defaultFileName));
        }
        else if(filePath == null){
            screenshotLocation = new File(String.format("%s%s.png",defaultFilePath,fileName));
        }
        else {
            screenshotLocation = new File(java.lang.String.format("%s%s.png",filePath,fileName));
        }
    }

    public void takeFullSizeScreenShot(String fileName, String filePath) throws IOException{
        this.fileName = fileName;
        this.filePath = filePath;
        checkNullFields();
        screenshot = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        fullSizeImage = read(screenshot);
        write(fullSizeImage, "png", screenshotLocation);
    }

    protected void processElement(String fileName, String filePath, WebElement element) throws IOException{
        takeFullSizeScreenShot(fileName, filePath);
        this.element = element;
        Point point = new Point(element.getLocation().getX(), element.getLocation().getY());
        int eleWidth = element.getSize().getWidth();
        int eleHeight = element.getSize().getHeight();
        BufferedImage elementScreenshot= fullSizeImage.getSubimage(point.getX(), point.getY(), eleWidth, eleHeight);
        write(elementScreenshot, "png", screenshot);
    }

    public void getScreenshot(String fileName, String filePath, WebElement element) throws IOException {
        processElement(fileName, filePath, element);
        copyFile(screenshot, screenshotLocation);
    }
}

