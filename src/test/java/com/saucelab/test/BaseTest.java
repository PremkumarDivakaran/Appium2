package com.saucelab.test;

import com.saucelab.config.ConfigManager;
import com.saucelab.driver.DriverInstance;
import com.saucelab.enums.RunMode;
import com.saucelab.screens.HomeScreen;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import com.saucelab.utils.AppiumServerManager;

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

    public HomeScreen launchApp(){
        return new HomeScreen();
    }

}
