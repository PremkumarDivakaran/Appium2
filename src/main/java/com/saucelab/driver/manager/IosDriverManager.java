package com.saucelab.driver.manager;

import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.ios.options.XCUITestOptions;
import com.saucelab.exceptions.UrlException;

import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.time.Duration;

public class IosDriverManager extends DriverManager {

    private String IOS_PATH = System.getProperty("user.dir") +
            "/src/test/resources/iOS-Simulator-MyRNDemoApp.1.3.0-162.zip";

    @Override
    public void setPlatformDriver() {
        XCUITestOptions options = new XCUITestOptions();
        options.setPlatformName("iOS");
        options.setDeviceName("iPhone 16 Pro");
        options.setPlatformVersion("18.2");
        options.setUdid("4AF6E2D2-547D-4205-ADC8-5B547D5DE70E");
        options.setApp(IOS_PATH);
        try {
            driver.set(new IOSDriver(new URI("http://127.0.0.1:4723").toURL(), options));
        } catch (URISyntaxException | MalformedURLException e) {
            throw new UrlException(e.getMessage());
        }
    }

}
