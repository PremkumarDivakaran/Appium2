package com.saucelab.learning;

import com.google.common.util.concurrent.Uninterruptibles;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import java.util.Map;

public class TestSsoLogin {

    @Test
    public void testRunner(){
        WebDriver driver = new ChromeDriver();
        try {
            driver.get("https://www.saucedemo.com/");

            Map.of("user-name", "standard_user", "password", "secret_sauce")
                    .forEach((key, value) -> driver.findElement(By.id(key)).sendKeys(value));
            driver.findElement(By.id("login-button")).click();
            Uninterruptibles.sleepUninterruptibly(10, java.util.concurrent.TimeUnit.SECONDS);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            driver.quit();
        }
    }

}
