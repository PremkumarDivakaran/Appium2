package com.saucelab.actions;

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

import static com.saucelab.driver.DriverInstance.getDriver;

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
        getDriver().perform(Collections.singletonList(doubleTap));
    }

    public static void scroll(){
        Dimension size = getDriver().manage().window().getSize();
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
        getDriver().perform(Collections.singletonList(scroll));
    }

    public static void scrollForElement(WebElement element, int timeOut){
        Dimension size = getDriver().manage().window().getSize();
        int startX = size.getWidth() / 2;
        int startY = size.getHeight() / 2;
        int endX = startX;
        int endY = (int) (size.getHeight() * 0.25);
        PointerInput finger = new PointerInput(PointerInput.Kind.TOUCH, "finger");
        WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(timeOut));
        while(true){
            try {
                WebElement ele = wait.until(ExpectedConditions.visibilityOf(element));
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
            getDriver().perform(Collections.singletonList(scroll));
        }
    }

}
