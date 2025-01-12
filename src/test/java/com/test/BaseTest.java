package com.test;

import org.config.ConfigManager;
import org.driver.DriverInstance;
import org.enums.RunMode;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.utils.AppiumServerManager;

public class BaseTest {

    @BeforeSuite
    public void startAppiumServer(){
        if(ConfigManager.getConfig().runmode() == RunMode.LOCAL) AppiumServerManager.getInstance().startAppiumServer();
    }

    @AfterSuite
    public void stopAppiumServer(){
        if(ConfigManager.getConfig().runmode() == RunMode.LOCAL) AppiumServerManager.getInstance().stopAppiumServer();
    }

    @BeforeMethod
    public void setupDriver(){
        DriverInstance.setDriver(ConfigManager.getConfig().platform());
    }
}
