package com.test;

import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.screens.SauceLab.HomeScreen;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.net.URI;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class SampleBrowserStackTest {

    public static final String USERNAME = "premkumardivakar_OfPs0o";
    public static final String ACCESS_KEY = "EcwoBo8iDeVzVMCYGMYg";
    public static final String URL = "https://" + USERNAME + ":" + ACCESS_KEY + "@hub-cloud.browserstack.com/wd/hub";

    private WebDriver driver;

    @BeforeClass
    public void setUp() throws Exception {
        DesiredCapabilities caps = new DesiredCapabilities();

        // Capabilities from browserstack.yml
        caps.setCapability("app", "bs://7d8fa0f700b22b33b2da6a2776d76ef6184743e5");
        caps.setCapability("device", "Samsung Galaxy S22 Ultra");
        caps.setCapability("os_version", "12.0");
        caps.setCapability("project", "MyApp Project");
        caps.setCapability("build", "MyApp Build #1");
        caps.setCapability("name", "Sample Test");

        driver = new AndroidDriver(new URI(URL).toURL(), caps);
    }

    @Test
    public void testAppLaunch() {
        HomeScreen homeScreen = new HomeScreen();
        String productPrice = homeScreen.getBackPackProductPrice();
        String totalPrice =  homeScreen
                .clickBackPackProduct()
                .clickAddToCart()
                .openCart()
                .getTotalPrice();
        assertThat(productPrice).isEqualTo(totalPrice);
    }

    @AfterClass
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
