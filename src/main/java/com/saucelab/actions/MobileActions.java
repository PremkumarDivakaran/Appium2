package com.saucelab.actions;

import com.saucelab.config.ConfigManager;
import com.saucelab.enums.PlatformType;
import io.appium.java_client.android.AndroidDriver;
import static com.saucelab.driver.DriverInstance.getDriver;

import io.appium.java_client.ios.IOSDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Pause;
import org.openqa.selenium.interactions.PointerInput;
import org.openqa.selenium.interactions.Sequence;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.Collections;

public class MobileActions {

    private MobileActions(){}

    private static Point getCenter(WebElement element){
        Point point = element.getLocation();
        Dimension dim = element.getSize();
        return new Point(point.getX() + dim.getWidth()/2, point.getY() + dim.getHeight()/2);
    }

    public static void doubleTap(WebElement element){
        Point centerOfElement = getCenter(element);
        PointerInput finger = new PointerInput(PointerInput.Kind.TOUCH, "finger");
        Sequence doubleTap = new Sequence(finger, 1)
                .addAction(finger.createPointerMove(Duration.ZERO, PointerInput.Origin.viewport(), centerOfElement))
                .addAction(finger.createPointerDown(PointerInput.MouseButton.LEFT.asArg()))
                .addAction(new Pause(finger, Duration.ofMillis(100)))
                .addAction(finger.createPointerUp(PointerInput.MouseButton.LEFT.asArg()))
                .addAction(new Pause(finger, Duration.ofMillis(100)))
                .addAction(finger.createPointerDown(PointerInput.MouseButton.LEFT.asArg()))
                .addAction(new Pause(finger, Duration.ofMillis(100)))
                .addAction(finger.createPointerUp(PointerInput.MouseButton.LEFT.asArg()));
        if(ConfigManager.getConfig().platform() == PlatformType.ANDROID)
            ((AndroidDriver)getDriver()).perform(Collections.singletonList(doubleTap));
        else if(ConfigManager.getConfig().platform() == PlatformType.IOS)
            ((IOSDriver)getDriver()).perform(Collections.singletonList(doubleTap));
    }

    public static void scroll(){
        Dimension size = ((AndroidDriver)getDriver()).manage().window().getSize();
        int startX = size.getWidth() / 2;
        int startY = size.getHeight() / 2;
        int endX = startX;
        int endY = (int) (size.getHeight() * 0.25);
        PointerInput finger = new PointerInput(PointerInput.Kind.TOUCH, "finger");
        Sequence scroll = new Sequence(finger, 1)
                .addAction(finger.createPointerMove(Duration.ZERO, PointerInput.Origin.viewport(), startX, startY))
                .addAction(finger.createPointerDown(PointerInput.MouseButton.LEFT.asArg()))
                .addAction(new Pause(finger, Duration.ofMillis(200)))
                .addAction(finger.createPointerMove(Duration.ofMillis(100), PointerInput.Origin.viewport(), endX, endY))
                .addAction(finger.createPointerUp(PointerInput.MouseButton.LEFT.asArg()));
        ((AndroidDriver)getDriver()).perform(Collections.singletonList(scroll));
    }

    public static void scrollForElement(By by, int timeOut){
        AndroidDriver driver = ((AndroidDriver)getDriver());
        Dimension size = driver.manage().window().getSize();
        int startX = size.getWidth() / 2;
        int startY = size.getHeight() / 2;
        int endX = startX;
        int endY = (int) (size.getHeight() * 0.25);
        PointerInput finger = new PointerInput(PointerInput.Kind.TOUCH, "finger");
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeOut));
        while(true){
            try {
                WebElement ele = wait.until(ExpectedConditions.visibilityOf(driver.findElement(by)));
                if(ele.isDisplayed()) break;
            }
            catch (Exception e){
                new RuntimeException(e.getMessage());
            }
            Sequence scroll = new Sequence(finger, 1)
                    .addAction(finger.createPointerMove(Duration.ZERO, PointerInput.Origin.viewport(), startX, startY))
                    .addAction(finger.createPointerDown(PointerInput.MouseButton.LEFT.asArg()))
                    .addAction(new Pause(finger, Duration.ofMillis(200)))
                    .addAction(finger.createPointerMove(Duration.ofMillis(100), PointerInput.Origin.viewport(), endX, endY))
                    .addAction(finger.createPointerUp(PointerInput.MouseButton.LEFT.asArg()));
            driver.perform(Collections.singletonList(scroll));
        }
    }



}
