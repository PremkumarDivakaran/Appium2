package org.driver.manager;

import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.ios.options.XCUITestOptions;
import org.exceptions.UrlException;

import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;

public class BrowserStackIosDriverManager extends DriverManager {

    private String IOS_PATH = System.getProperty("user.dir") +
            "/src/test/resources/iOS-Simulator-MyRNDemoApp.1.3.0-162.zip";

    @Override
    public void setPlatformDriver() {
        XCUITestOptions options = new XCUITestOptions();
        options.setDeviceName("iPhone 15");
        options.setPlatformVersion("16.0");
        options.setApp(IOS_PATH);
        try {
            driver.set(new IOSDriver(new URI("http://127.0.0.1:4723").toURL(), options));
        } catch (URISyntaxException | MalformedURLException e) {
            throw new UrlException(e.getMessage());
        }
    }

}
