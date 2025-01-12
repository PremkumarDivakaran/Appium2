package org.driver.factory;


import org.driver.manager.AndroidDriverManager;
import org.driver.manager.DriverManager;
import org.driver.manager.IosDriverManager;
import org.exceptions.PlatformException;
import org.enums.PlatformType;

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
