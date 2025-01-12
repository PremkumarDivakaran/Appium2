package org.driver.manager;

import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.ios.options.XCUITestOptions;
import org.exceptions.UrlException;

import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;

public class BrowserStackIosDriverManager extends DriverManager {


    @Override
    public void setPlatformDriver() {
        XCUITestOptions options = new XCUITestOptions();
        try {
            driver.set(new IOSDriver(new URI("http://hub-cloud.browserstack.com/wd/hub").toURL(), options));
        } catch (URISyntaxException | MalformedURLException e) {
            throw new UrlException(e.getMessage());
        }
    }

}
