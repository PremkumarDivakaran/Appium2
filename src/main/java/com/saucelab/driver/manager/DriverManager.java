package com.saucelab.driver.manager;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.WebDriver;

public abstract class DriverManager {

    public static ThreadLocal<AppiumDriver> driver = new ThreadLocal<>();

    public abstract void setPlatformDriver();

    public static AppiumDriver getDriver(){
        return driver.get();
    }

}
