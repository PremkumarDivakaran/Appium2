package com.saucelab.driver.manager;

import io.appium.java_client.android.AndroidDriver;
import com.saucelab.exceptions.UrlException;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.HashMap;

public class BrowserStackAndroidDriverManager extends DriverManager {

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
        capabilities.setCapability("platformName", "android");
        capabilities.setCapability("appium:platformVersion", "12.0");
        capabilities.setCapability("appium:deviceName", "Samsung Galaxy S22 Ultra");
        capabilities.setCapability("appium:usePlugins", "element-wait");
        capabilities.setCapability("appium:app", "bs://7d8fa0f700b22b33b2da6a2776d76ef6184743e5");
        capabilities.setCapability("bstack:options", bstackOptions);

        try {
            driver.set(new AndroidDriver(new URI("http://hub-cloud.browserstack.com/wd/hub").toURL(), capabilities));
        } catch (URISyntaxException | MalformedURLException e) {
            throw new UrlException(e.getMessage());
        }
    }

}
