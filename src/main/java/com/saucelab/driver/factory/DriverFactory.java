package com.saucelab.driver.factory;


import com.saucelab.driver.manager.AndroidDriverManager;
import com.saucelab.driver.manager.DriverManager;
import com.saucelab.driver.manager.IosDriverManager;
import com.saucelab.exceptions.PlatformException;
import com.saucelab.enums.PlatformType;

public class DriverFactory {

    private DriverFactory(){}

    public static DriverManager setDriver(PlatformType platformType){
        switch (platformType){
            case ANDROID:
                return new AndroidDriverManager();
            case IOS:
                return new IosDriverManager();
            default:
                throw new PlatformException("Invalid Platform Provided");
        }
    }

}
