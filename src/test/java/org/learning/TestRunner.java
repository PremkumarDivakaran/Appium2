package org.learning;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import com.google.common.collect.ImmutableMap;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;
import org.openqa.selenium.*;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;
import org.openqa.selenium.interactions.Pause;
import org.openqa.selenium.interactions.PointerInput;
import org.openqa.selenium.interactions.Sequence;
import org.openqa.selenium.remote.RemoteWebElement;
import org.provider.SauceLabAndroidAppProvider;
import org.screens.SauceLab.HomeScreen;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.utils.AppiumServerManager;
import static org.assertj.core.api.Assertions.assertThat;
import java.awt.*;
import java.io.File;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.time.Duration;
import java.util.Arrays;
import java.util.Map;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import java.util.Collections;

public class TestRunner {

    AppiumDriverLocalService service;

    //@Test
    public void androidAppLaunch() {
        /*Configuration.browser = SauceLabAndroidAppProvider.class.getName();
        SelenideAppium.launchApp();
        HomeScreen homeScreen = screen(HomeScreen.class);
        String productPrice = homeScreen.getProductPrice();
        System.out.println(productPrice);
        String totalPrice = homeScreen
                .clickProduct()
                .clickAddToCart()
                .openCart()
                .getTotalPrice();
        System.out.println(totalPrice);*/

        /*String productPrice = $(By.xpath("//android.widget.TextView[@content-desc=\"store item text\" and @text=\"Sauce Labs Backpack\"]/../following-sibling::android.widget.TextView")).getText();
        System.out.println(productPrice);
        $(By.xpath("//android.widget.TextView[@content-desc=\"store item text\" and @text=\"Sauce Labs Backpack\"]")).click();

        $(AppiumBy.accessibilityId("Add To Cart button")).click();
        $(By.xpath("//android.view.ViewGroup[@content-desc=\"cart badge\"]/android.widget.ImageView")).click();

        String totalPrice = $(By.xpath("//android.widget.TextView[@content-desc=\"total price\"]")).getText();
        System.out.println(totalPrice);

        Assert.assertEquals(productPrice, totalPrice);*/


        $(By.xpath("//android.view.ViewGroup[@content-desc=\"open menu\"]/android.widget.ImageView")).click();
        $(By.xpath("//android.widget.TextView[@text=\"Drawing\"]")).click();




    }

    @BeforeClass
    public void startAppiumServer(){
        /*service = new AppiumServiceBuilder()
                .usingPort(4723)
                .build();
        service.start();*/

        /*service = new AppiumServiceBuilder()
                //.withAppiumJS(new File("/usr/local/lib/node_modules/appium/build/lib/main.js"))
                .withAppiumJS(new File("/opt/homebrew/lib/node_modules/appium/build/lib/main.js"))
                .withIPAddress("127.0.0.1")
                .usingPort(4723)
                .build();
        service.start();*/
        AppiumServerManager.getInstance().startAppiumServer();
    }

    @AfterClass
    public void quitAppiumServer(){
        //service.stop();
        AppiumServerManager.getInstance().stopAppiumServer();
    }

    //@Test
    public void launchAndroidApp(){
        /*Configuration.browser = SauceLabAndroidAppProvider.class.getName();
        SelenideAppium.launchApp();

        HomeScreen homeScreen = screen(HomeScreen.class);
        String productPrice = homeScreen.getProductPrice();
        System.out.println(productPrice);
        String totalPrice = homeScreen
                .clickProduct()
                .clickAddToCart()
                .openCart()
                .getTotalPrice();
        System.out.println(totalPrice);
        Assert.assertEquals(productPrice, totalPrice);*/
    }


    //@Test
    public void testZoom() throws MalformedURLException {
        String apkPath = System.getProperty("user.dir") +
                "/src/test/resources/Android-MyDemoAppRN.1.3.0.build-244.apk";
        UiAutomator2Options options = new UiAutomator2Options();
        options.setDeviceName("My_Phone");
        options.setApp(apkPath);
        AndroidDriver driver = new AndroidDriver(new URL("http://127.0.0.1:4723"), options);
        driver.findElement(By.xpath("\"//android.view.ViewGroup[@content-desc=\\\"open menu\\\"]/android.widget.ImageView\"")).click();
        driver.findElement(By.xpath("//android.widget.TextView[@text=\"Drawing\"]")).click();

        WebElement element = driver.findElement(By.xpath("//android.view.View[@resource-id=\"signature-pad\"]/android.view.View/android.widget.Image[2]"));

        int x = element.getLocation().getX() + element.getSize().getWidth() / 2;
        int y = element.getLocation().getY() + element.getSize().getHeight() / 2;

        PointerInput finger1 = new PointerInput(PointerInput.Kind.TOUCH, "finger1");
        PointerInput finger2 = new PointerInput(PointerInput.Kind.TOUCH, "finger2");

        Sequence sequence1 = new Sequence(finger1, 1)
                .addAction(finger1.createPointerMove(Duration.ZERO, PointerInput.Origin.viewport(), x, y))
                .addAction(finger1.createPointerDown(PointerInput.MouseButton.LEFT.asArg()))
                .addAction(new Pause(finger1, Duration.ofMillis(200)))
                .addAction(finger1.createPointerMove(Duration.ofMillis(200), PointerInput.Origin.viewport(), x+20, y))
                .addAction(finger1.createPointerUp(PointerInput.MouseButton.LEFT.asArg()));

        Sequence sequence2 = new Sequence(finger2, 1)
                .addAction(finger2.createPointerMove(Duration.ZERO, PointerInput.Origin.viewport(), x, y))
                .addAction(finger2.createPointerDown(PointerInput.MouseButton.LEFT.asArg()))
                .addAction(new Pause(finger2, Duration.ofMillis(200)))
                .addAction(finger2.createPointerMove(Duration.ofMillis(200), PointerInput.Origin.viewport(), x-20, y))
                .addAction(finger2.createPointerUp(PointerInput.MouseButton.LEFT.asArg()));

        driver.perform(Arrays.asList(sequence1, sequence2));

    }

    @Test
    public void testMethod(){
        open("https://google.com");
        $(By.name("q")).setValue("Selenide").pressEnter();
        Selenide.sleep(4000);
    }

    @Test
    public void testRunner() throws MalformedURLException {
        String apkPath = System.getProperty("user.dir") +
                "/src/test/resources/ApiDemos-debug.apk";
        UiAutomator2Options options = new UiAutomator2Options();
        options.setDeviceName("My_Android_Device");
        options.setApp(apkPath);
        AndroidDriver driver = new AndroidDriver(new URL("http://127.0.0.1:4723"), options);

        driver.findElement(AppiumBy.accessibilityId("Views")).click();
        driver.findElement(AppiumBy.accessibilityId("Expandable Lists")).click();
        driver.findElement(AppiumBy.accessibilityId("1. Custom Adapter")).click();
        WebElement peopleNames = driver.findElement(AppiumBy.xpath("//android.widget.TextView[@text='People Names']"));
        ((JavascriptExecutor) driver).executeScript("mobile: longClickGesture", ImmutableMap.of(
                "elementId", ((RemoteWebElement) peopleNames).getId(),
                "duration", 3000
        ));

        WebElement sampleMenu = driver.findElement(AppiumBy.xpath("//android.widget.TextView[@text='Sample menu']"));
        assertThat(sampleMenu.isDisplayed()).isTrue();
    }

    @Test
    public void testRunner1() throws MalformedURLException, URISyntaxException {
        String apkPath = System.getProperty("user.dir") +
                "/src/test/resources/ApiDemos-debug.apk";
        UiAutomator2Options options = new UiAutomator2Options();
        options.setDeviceName("My_Android_Device");
        options.setApp(apkPath);
        AndroidDriver driver = new AndroidDriver(new URI("http://127.0.0.1:4723").toURL(), options);

        driver.findElement(AppiumBy.accessibilityId("Views")).click();
        driver.findElement(AppiumBy.accessibilityId("Expandable Lists")).click();
        driver.findElement(AppiumBy.accessibilityId("3. Simple Adapter")).click();
        driver.findElement(AppiumBy.xpath("//android.widget.TextView[@resource-id=\"android:id/text1\" and @text=\"Group 0\"]")).click();

        WebElement child0 = driver.findElement(AppiumBy.xpath("//android.widget.TextView[@resource-id=\"android:id/text1\" and @text=\"Child 0\"]"));
        ((JavascriptExecutor) driver).executeScript("mobile: doubleClickGesture", ImmutableMap.of(
                "elementId", ((RemoteWebElement) child0).getId(),
                "duration", 1000
        ));
        assertThat(child0.isDisplayed()).isTrue();
    }

}
