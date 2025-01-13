package com.saucelab.screens;

import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.support.PageFactory;

import static com.saucelab.driver.DriverInstance.getDriver;

public class BaseScreen {

    public BaseScreen(){
        PageFactory.initElements(new AppiumFieldDecorator(getDriver()), this);
    }

}
