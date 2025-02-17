package com.saucelab.driver;

import com.saucelab.config.ConfigManager;
import com.saucelab.driver.factory.BrowserStackDriverFactory;
import com.saucelab.driver.factory.DriverFactory;
import com.saucelab.driver.manager.DriverManager;
import com.saucelab.enums.PlatformType;
import com.saucelab.enums.RunMode;
import io.appium.java_client.AppiumDriver;

public class DriverInstance {

    private DriverInstance(){}

    public static void setDriver(PlatformType platformType){
        if(ConfigManager.getConfig().runmode() == RunMode.LOCAL)
            DriverFactory.setDriver(platformType).setPlatformDriver();
        else if(ConfigManager.getConfig().runmode() == RunMode.BROWSERSTACK)
            BrowserStackDriverFactory.setDriver(platformType).setPlatformDriver();
    }

    public static AppiumDriver getDriver(){
        return DriverManager.getDriver();
    }

}
