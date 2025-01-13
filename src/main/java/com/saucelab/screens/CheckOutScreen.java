package com.saucelab.screens;

import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import org.openqa.selenium.WebElement;


public class CheckOutScreen extends BaseScreen {

    @AndroidFindBy(xpath = "//android.widget.TextView[@content-desc=\"total price\"]")
    @iOSXCUITFindBy(accessibility = "total price")
    private WebElement totalPrice;

    public String getTotalPrice(){
        return totalPrice.getText();
    }
}
