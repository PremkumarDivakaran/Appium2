package com.saucelab.driver.manager;

import com.saucelab.exceptions.UrlException;
import io.appium.java_client.ios.IOSDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.HashMap;

public class BrowserStackIosDriverManager extends DriverManager {

    @Override
    public void setPlatformDriver() {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        String browserstackUsername = System.getenv("BROWSERSTACK_USERNAME");
        String browserstackAccessKey = System.getenv("BROWSERSTACK_ACCESS_KEY");
        if(browserstackUsername == null || browserstackAccessKey == null)
            throw new IllegalArgumentException("Browserstack Username and AccessKey not Provided");
        HashMap<String, Object> bstackOptions = new HashMap<>();
        bstackOptions.put("userName", browserstackUsername);
        bstackOptions.put("accessKey", browserstackAccessKey);
        bstackOptions.put("appiumVersion", "2.12.1");
        capabilities.setCapability("platformName", "ios");
        capabilities.setCapability("appium:platformVersion", "17");
        capabilities.setCapability("appium:deviceName", "iPhone 15 Pro");
        capabilities.setCapability("appium:usePlugins", "element-wait");
        capabilities.setCapability("appium:app", "bs://f010869b0ad896c6920d28bf1a59e12f3dcf3f4e");
        capabilities.setCapability("bstack:options", bstackOptions);

        try {
            driver.set(new IOSDriver(new URI("http://hub-cloud.browserstack.com/wd/hub").toURL(), capabilities));
        } catch (URISyntaxException | MalformedURLException e) {
            throw new UrlException(e.getMessage());
        }
    }

}
