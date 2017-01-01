package com.kahyalar.selenium;

import org.junit.Assert;
import org.junit.Test;

import java.io.IOException;

import static org.junit.Assert.assertTrue;

/**
 * Created by Furkan on 28.11.2016.
 */
public class FullSizeScreenshotTest extends BaseTest{
    @Test
    public void fullsizeScreenshotTests() throws IOException {
        screenshot.getScreenshot(null,null);
        screenshot.getScreenshot("merhaba" ,null);
        screenshot.getScreenshot("hi guys", "/Users/kahyalar/Desktop/");

        assertTrue("merhaba is present", isScreenshotTaken("merhaba"));
        assertTrue("hi guys is present", isScreenshotTaken("hi guys"));
        assertTrue("screenshot is present", isScreenshotTaken("screenshot"));
    }
}
