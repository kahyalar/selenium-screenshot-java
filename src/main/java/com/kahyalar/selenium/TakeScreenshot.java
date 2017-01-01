package com.kahyalar.selenium;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Date;

/**
 * Created by İlker Furkan KAHYALAR
 * Contact : furkankahyalar@gmail.com
 */
public class TakeScreenshot {
    private File screenshotLocation;
    private File screenshot;
    private BufferedImage fullImg;
    private String fileName;
    private String filePath;
    private String defaultFileName = "screenshot";
    private String defaultFilePath = System.getProperty("user.home")+"/Desktop/";
    private WebElement element;
    private WebDriver driver;

    public TakeScreenshot(WebDriver driver){
        this.driver = driver;
    }

    private void checkNullation(){
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
        checkNullation();
        screenshot = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        fullImg = ImageIO.read(screenshot);
    }

    private void processElement(WebElement element) throws IOException{
        this.element = element;
        Point point = element.getLocation();
        int eleWidth = element.getSize().getWidth();
        int eleHeight = element.getSize().getHeight();
        BufferedImage eleScreenshot= fullImg.getSubimage(point.getX(), point.getY(), eleWidth, eleHeight);
        ImageIO.write(eleScreenshot, "png", screenshot);
    }

    public void getScreenshot(String fileName, String filePath) throws IOException {
        takeFullSizeScreenShot(fileName, filePath);
        FileUtils.copyFile(screenshot, screenshotLocation);
    }

    public void getScreenshotByClassName(String fileName, String filePath, String className) throws IOException {
        takeFullSizeScreenShot(fileName, filePath);
        element = driver.findElement(By.className(className));
        processElement(element);
        FileUtils.copyFile(screenshot, screenshotLocation);
    }

    public void getScreenshotByXpath(String fileName, String filePath, String xpath) throws IOException {
        takeFullSizeScreenShot(fileName, filePath);
        element = driver.findElement(By.xpath(xpath));
        processElement(element);
        FileUtils.copyFile(screenshot, screenshotLocation);
    }

    public void getScreenshotById(String fileName, String filePath, String id) throws IOException {
        takeFullSizeScreenShot(fileName, filePath);
        element = driver.findElement(By.id(id));
        processElement(element);
        FileUtils.copyFile(screenshot, screenshotLocation);
    }

    public void getScreenshotByCss(String fileName, String filePath, String selector) throws IOException {
        takeFullSizeScreenShot(fileName, filePath);
        element = driver.findElement(By.cssSelector(selector));
        processElement(element);
        FileUtils.copyFile(screenshot, screenshotLocation);
    }

    public void getScreenshotByLinkText(String fileName, String filePath, String linkText) throws IOException {
        takeFullSizeScreenShot(fileName, filePath);
        element = driver.findElement(By.linkText(linkText));
        processElement(element);
        FileUtils.copyFile(screenshot, screenshotLocation);
    }

    public void getScreenshotByName(String fileName, String filePath, String name) throws IOException {
        takeFullSizeScreenShot(fileName, filePath);
        element = driver.findElement(By.name(name));
        processElement(element);
        FileUtils.copyFile(screenshot, screenshotLocation);
    }

    public void getScreenshotByTagName(String fileName, String filePath, String tag) throws IOException {
        takeFullSizeScreenShot(fileName, filePath);
        element = driver.findElement(By.tagName(tag));
        processElement(element);
        FileUtils.copyFile(screenshot, screenshotLocation);
    }

    public void getScreenshotByPartialLinkText(String fileName, String filePath, String partialLink) throws IOException {
        takeFullSizeScreenShot(fileName, filePath);
        element = driver.findElement(By.partialLinkText(partialLink));
        processElement(element);
        FileUtils.copyFile(screenshot, screenshotLocation);
    }
}

