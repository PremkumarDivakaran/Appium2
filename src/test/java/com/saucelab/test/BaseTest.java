package com.saucelab.test;

import com.saucelab.config.ConfigManager;
import static com.saucelab.driver.DriverInstance.getDriver;
import static com.saucelab.driver.DriverInstance.setDriver;
import com.saucelab.enums.RunMode;
import com.saucelab.screens.HomeScreen;
import org.testng.annotations.AfterMethod;
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
        setDriver(ConfigManager.getConfig().platform());
    }

    @AfterMethod
    public void quitDriver(){
        getDriver().quit();
    }

    public HomeScreen launchApp(){
        return new HomeScreen();
    }

}
