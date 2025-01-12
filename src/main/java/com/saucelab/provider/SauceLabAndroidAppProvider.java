package com.saucelab.provider;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import org.openqa.selenium.WebDriver;

import java.net.MalformedURLException;
import java.net.URL;


public class SauceLabAndroidAppProvider {

    private SauceLabAndroidAppProvider(){}

    private static final String APK_PATH = System.getProperty("user.dir") +
            "/src/test/resources/Android-MyDemoAppRN.1.3.0.build-244.apk";

    public static WebDriver createDriver() {
        UiAutomator2Options options = new UiAutomator2Options();
        options.setDeviceName("My_Android_Device");
        options.setApp(APK_PATH);
        try {
            return new AndroidDriver(new URL("http://127.0.0.1:4723"), options);
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        }
    }

}
