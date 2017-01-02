package com.kahyalar.selenium;

import org.openqa.selenium.*;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import static javax.imageio.ImageIO.read;
import static org.apache.commons.io.FileUtils.*;

/**
 * Created by İlker Furkan KAHYALAR
 * Contact : furkankahyalar@gmail.com
 */

public class SeleniumScreenshot {
    private File screenshotLocation;
    private File screenshot;
    private BufferedImage fullImg;
    private String fileName,filePath;
    private String defaultFileName = "screenshot";
    private String defaultFilePath = System.getProperty("user.home")+"/Desktop/";
    private WebElement element;
    private WebDriver driver;

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

    private void takeFullSizeScreenShot(String fileName, String filePath) throws IOException{
        this.fileName = fileName;
        this.filePath = filePath;
        checkNullFields();
        screenshot = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        fullImg = read(screenshot);
    }

    private void processElement(WebElement element) throws IOException{
        this.element = element;
        Point point = element.getLocation();
        int eleWidth = element.getSize().getWidth();
        int eleHeight = element.getSize().getHeight();
        BufferedImage eleScreenshot= fullImg.getSubimage(point.getX(), point.getY(), eleWidth, eleHeight);
        ImageIO.write(eleScreenshot, "png", screenshot);
    }

    public void getScreenshot(String fileName, String filePath, WebElement element) throws IOException {
        takeFullSizeScreenShot(fileName, filePath);
        processElement(element);
        copyFile(screenshot, screenshotLocation);
    }
}

