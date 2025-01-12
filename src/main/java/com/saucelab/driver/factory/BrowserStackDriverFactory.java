package com.saucelab.driver.factory;


import com.saucelab.driver.manager.BrowserStackAndroidDriverManager;
import com.saucelab.driver.manager.BrowserStackIosDriverManager;
import com.saucelab.driver.manager.DriverManager;
import com.saucelab.exceptions.PlatformException;
import com.saucelab.enums.PlatformType;

public class BrowserStackDriverFactory {

    private BrowserStackDriverFactory(){}

    public static DriverManager setDriver(PlatformType platformType){
        switch (platformType){
            case ANDROID:
                return new BrowserStackAndroidDriverManager();
            case IOS:
                return new BrowserStackIosDriverManager();
            default:
                throw new PlatformException("Invalid Platform Provided");
        }
    }

}
