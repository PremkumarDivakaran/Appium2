package com.test;

import org.driver.DriverInstance;
import org.framework.PlatformType;
import org.testng.annotations.BeforeMethod;

public class BaseTest {

    @BeforeMethod
    public void setupDriver(){
        DriverInstance.setDriver(PlatformType.ANDROID);
    }
}
