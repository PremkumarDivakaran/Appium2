package org.driver;


import org.driver.factory.DriverFactory;
import org.driver.manager.DriverManager;
import org.framework.PlatformType;
import org.openqa.selenium.WebDriver;

public class DriverInstance {

    private DriverInstance(){}

    public static void setDriver(PlatformType platformType){
        DriverFactory.setDriver(platformType).setPlatformDriver();
    }

    public static WebDriver getDriver(){
        return DriverManager.getDriver();
    }

}
