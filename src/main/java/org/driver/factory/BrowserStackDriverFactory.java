package org.driver.factory;


import org.driver.manager.*;
import org.exceptions.PlatformException;
import org.framework.PlatformType;

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
