package org.driver.manager;

import org.openqa.selenium.WebDriver;

public abstract class DriverManager {

    public static ThreadLocal<WebDriver> driver = new ThreadLocal<>();

    public abstract void setPlatformDriver();

    public static WebDriver getDriver(){
        return driver.get();
    }

}
