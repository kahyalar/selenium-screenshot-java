package com.kahyalar.selenium;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

/**
 * Created by İlker Furkan KAHYALAR
 * Contact : furkankahyalar@gmail.com
 */
public class SeleniumScreenshot {
    private File screenshotLocation, screenshot;
    private BufferedImage fullImg;
    private String fileName, filePath;
    private WebElement ele;
    private WebDriver driver;

    public SeleniumScreenshot(WebDriver driver){
        this.driver = driver;
    }

    private void checkNullFileName(){
        if(fileName == null){
            screenshotLocation = new File(java.lang.String.format("%sscreenshot.png",filePath));
        }
        else {
            screenshotLocation = new File(java.lang.String.format("%s%s.png",filePath,fileName));
        }
    }

    private void takeFullSizeScreenShot(String fileName, String filePath) throws IOException{
        this.fileName = fileName;
        this.filePath = filePath;
        screenshot = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        fullImg = ImageIO.read(screenshot);
    }

    private void processElement(WebElement ele) throws IOException{
        this.ele = ele;
        Point point = ele.getLocation();
        int eleWidth = ele.getSize().getWidth();
        int eleHeight = ele.getSize().getHeight();
        BufferedImage eleScreenshot= fullImg.getSubimage(point.getX(), point.getY(), eleWidth, eleHeight);
        ImageIO.write(eleScreenshot, "png", screenshot);
    }

    public void getScreenshot(String fileName, String filePath) throws IOException {
        takeFullSizeScreenShot(fileName, filePath);
        checkNullFileName();
        FileUtils.copyFile(screenshot, screenshotLocation);
    }

    public void getScreenshotByClassName(String fileName, String filePath, String className) throws IOException {
        takeFullSizeScreenShot(fileName, filePath);
        ele = driver.findElement(By.className(className));
        processElement(ele);
        checkNullFileName();
        FileUtils.copyFile(screenshot, screenshotLocation);
    }

    public void getScreenshotByXpath(String fileName, String filePath, String xpath) throws IOException {
        takeFullSizeScreenShot(fileName, filePath);
        ele = driver.findElement(By.xpath(xpath));
        processElement(ele);
        checkNullFileName();
        FileUtils.copyFile(screenshot, screenshotLocation);
    }

    public void getScreenshotById(String fileName, String filePath, String id) throws IOException {
        takeFullSizeScreenShot(fileName, filePath);
        ele = driver.findElement(By.id(id));
        processElement(ele);
        checkNullFileName();
        FileUtils.copyFile(screenshot, screenshotLocation);
    }

    public void getScreenshotByCss(String fileName, String filePath, String selector) throws IOException {
        takeFullSizeScreenShot(fileName, filePath);
        ele = driver.findElement(By.cssSelector(selector));
        processElement(ele);
        checkNullFileName();
        FileUtils.copyFile(screenshot, screenshotLocation);
    }

    public void getScreenshotByLinkText(String fileName, String filePath, String linkText) throws IOException {
        takeFullSizeScreenShot(fileName, filePath);
        ele = driver.findElement(By.linkText(linkText));
        processElement(ele);
        checkNullFileName();
        FileUtils.copyFile(screenshot, screenshotLocation);
    }

    public void getScreenshotByName(String fileName, String filePath, String name) throws IOException {
        takeFullSizeScreenShot(fileName, filePath);
        ele = driver.findElement(By.name(name));
        processElement(ele);
        checkNullFileName();
        FileUtils.copyFile(screenshot, screenshotLocation);
    }

    public void getScreenshotByTagName(String fileName, String filePath, String tag) throws IOException {
        takeFullSizeScreenShot(fileName, filePath);
        ele = driver.findElement(By.tagName(tag));
        processElement(ele);
        checkNullFileName();
        FileUtils.copyFile(screenshot, screenshotLocation);
    }

    public void getScreenshotByPartialLinkText(String fileName, String filePath, String partialLink) throws IOException {
        takeFullSizeScreenShot(fileName, filePath);
        ele = driver.findElement(By.partialLinkText(partialLink));
        processElement(ele);
        checkNullFileName();
        FileUtils.copyFile(screenshot, screenshotLocation);
    }
}

