package org.driver.manager;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import org.exceptions.UrlException;

import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;

public class AndroidDriverManager extends DriverManager {

    private String APK_PATH = System.getProperty("user.dir") +
            "/src/test/resources/Android-MyDemoAppRN.1.3.0.build-244.apk";

    @Override
    public void setPlatformDriver() {
        UiAutomator2Options options = new UiAutomator2Options();
        options.setDeviceName("My_Android_Device");
        options.setApp(APK_PATH);
        try {
            driver.set(new AndroidDriver(new URI("http://127.0.0.1:4723").toURL(), options));
        } catch (URISyntaxException | MalformedURLException e) {
            throw new UrlException(e.getMessage());
        }
    }

}
