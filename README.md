# selenium-screenshot-java [![Release](https://jitpack.io/v/kahyalar/selenium-screenshot-java.svg)]
A tool for taking screenshots with WebElements.

# Installation
It's so easy to install, just go to your pom.xml file and add these lines.

```java
	<repositories>
		<repository>
		    <id>jitpack.io</id>
		    <url>https://jitpack.io</url>
		</repository>
	</repositories>
	<dependency>
	    <groupId>com.github.kahyalar</groupId>
	    <artifactId>selenium-screenshot-java</artifactId>
	    <version>1.1</version>
	</dependency>
```  
  
# Usage
Only one thing is importantant during this process. 

Just create an object for screenshot:
```java
..
...
   SeleniumScreenshot screenshot = new SeleniumScreenshot(driver);
```

Than use the method for taking screenshot of an element:
```java
screenshot.getScreenshot(String fileName, String filePath, WebElement element);
```

You can also take fullsize screenshot of your browser:
```java
screenshot.takeFullSizeScreenShot(String fileName, String filePath);
```

But there is a something we have to do. In all retina displays(Macbook's, iMac's) have a default double-pixel squashing. 
So what should we do?
It's really easy! Now, just go for RetinaScreenshot object.

```java
RetinaScreenshot retinaScreenshot = new RetinaScreenshot(driver);
```
You are all set, just go and grap some screenshots!

# Contribution

Feel free to share your ideas with me. Any new features or bug issues just let me know. 
Open source rocks!

#
