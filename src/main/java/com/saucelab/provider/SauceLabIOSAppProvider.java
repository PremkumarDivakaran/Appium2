package com.saucelab.provider;

import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.ios.options.XCUITestOptions;
import org.openqa.selenium.WebDriver;

import java.net.MalformedURLException;
import java.net.URL;


public class SauceLabIOSAppProvider {

    private static final String filePath = System.getProperty("user.dir") +
            "/src/test/resources/iOS-Simulator-MyRNDemoApp.1.3.0-162.zip";

    public static WebDriver createDriver() {
        XCUITestOptions options = new XCUITestOptions();
        options.setDeviceName("iPhone 15");
        options.setPlatformVersion("16.0");
        options.setApp(filePath);
        try {
            return new IOSDriver(new URL("http://127.0.0.1:4723"), options);
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        }
    }

}
