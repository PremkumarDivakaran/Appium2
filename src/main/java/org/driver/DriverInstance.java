package org.driver;

import org.config.ConfigManager;
import org.driver.factory.BrowserStackDriverFactory;
import org.driver.factory.DriverFactory;
import org.driver.manager.DriverManager;
import org.enums.PlatformType;
import org.enums.RunMode;
import org.openqa.selenium.WebDriver;

public class DriverInstance {

    private DriverInstance(){}

    public static void setDriver(PlatformType platformType){
        if(ConfigManager.getConfig().runmode() == RunMode.LOCAL)
            DriverFactory.setDriver(platformType).setPlatformDriver();
        else if(ConfigManager.getConfig().runmode() == RunMode.BROWSERSTACK)
            BrowserStackDriverFactory.setDriver(platformType).setPlatformDriver();
    }

    public static WebDriver getDriver(){
        return DriverManager.getDriver();
    }

}
