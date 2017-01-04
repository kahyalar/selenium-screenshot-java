package com.kahyalar.selenium;

import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.awt.image.BufferedImage;
import java.io.IOException;

import static javax.imageio.ImageIO.write;

/**
 * Created by kahyalar on 04/01/2017.
 */
public class RetinaScreenshot extends SeleniumScreenshot {
    public RetinaScreenshot(WebDriver driver) {
        super(driver);
    }

    @Override
    protected void processElement(String fileName, String filePath, WebElement element) throws IOException {
        takeFullSizeScreenShot(fileName, filePath);
        this.element = element;
        Point point = new Point((element.getLocation().getX()) * 2, (element.getLocation().getY()) * 2);
        int eleWidth = (element.getSize().getWidth()) * 2;
        int eleHeight = (element.getSize().getHeight()) * 2;
        BufferedImage elementScreenshot= fullSizeImage.getSubimage(point.getX(), point.getY(), eleWidth, eleHeight);
        write(elementScreenshot, "png", screenshot);
    }
}
