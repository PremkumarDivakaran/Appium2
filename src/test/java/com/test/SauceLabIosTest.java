package com.test;


import org.provider.SauceLabIOSAppProvider;
import org.testng.annotations.Test;

public class SauceLabIosTest {

    @Test
    public void testLaunchApp() {
        System.out.println("Launching IOS App");
        SauceLabIOSAppProvider.createDriver();
    }

}
