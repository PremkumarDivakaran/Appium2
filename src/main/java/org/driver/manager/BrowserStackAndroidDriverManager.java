package org.driver.manager;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import org.exceptions.UrlException;
import org.openqa.selenium.MutableCapabilities;

import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;

public class BrowserStackAndroidDriverManager extends DriverManager {

    private String APK_PATH = System.getProperty("user.dir") +
            "/src/test/resources/Android-MyDemoAppRN.1.3.0.build-244.apk";

    @Override
    public void setPlatformDriver() {
        MutableCapabilities capabilities = new UiAutomator2Options();
        try {
            driver.set(new AndroidDriver(new URI("http://127.0.0.1:4723/wd/hub").toURL(), capabilities));
        } catch (URISyntaxException | MalformedURLException e) {
            throw new UrlException(e.getMessage());
        }
    }

}
