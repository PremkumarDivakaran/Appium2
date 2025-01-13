package com.saucelab.screens;

import com.saucelab.actions.MobileActions;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import org.openqa.selenium.WebElement;


public class HomeScreen extends BaseScreen {

    @AndroidFindBy(xpath = "//android.widget.TextView[@content-desc=\"store item text\" and @text=\"Sauce Labs Backpack\"]")
    @iOSXCUITFindBy(accessibility = "Sauce Labs Backpack")
    private WebElement backPackProductName;

    @AndroidFindBy(xpath = "//android.widget.TextView[@content-desc=\"store item text\" and @text=\"Sauce Labs Backpack\"]/../following-sibling::android.widget.TextView")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"store item price\" and @label=\"$29.99\"]")
    private WebElement backPackProductPrice;

    @AndroidFindBy(xpath = "//android.widget.TextView[@content-desc=\"store item text\" and @text=\"Sauce Labs Bolt T-Shirt\"]")
    @iOSXCUITFindBy(accessibility = "Sauce Labs Bolt T-Shirt")
    private WebElement tShirtProductName;

    @AndroidFindBy(xpath = "//android.widget.TextView[@content-desc=\"store item text\" and @text=\"Sauce Labs Bolt T-Shirt\"]/../following-sibling::android.widget.TextView")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"store item price\" and @label=\"$15.99\"]")
    private WebElement tShirtProductPrice;

    @AndroidFindBy(xpath = "//android.widget.TextView[@content-desc=\"store item text\" and @text=\"Sauce Labs Onesie\"]")
    @iOSXCUITFindBy(accessibility = "Sauce Labs Onesie")
    private WebElement onesieProductName;

    @AndroidFindBy(xpath = "//android.widget.TextView[@content-desc=\"store item text\" and @text=\"Sauce Labs Onesie\"]/../following-sibling::android.widget.TextView")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"store item price\" and @label=\"$7.99\"]")
    private WebElement onesieProductPrice;

    public String getBackPackProductPrice(){
        return backPackProductPrice.getText();
    }

    public String getTshirtProductPrice(){
        return tShirtProductPrice.getText();
    }

    public String getOnesieProductPrice(){
        return onesieProductPrice.getText();
    }

    public ProductInfoScreen clickBackPackProduct(){
        backPackProductName.click();
        return new ProductInfoScreen();
    }

    public ProductInfoScreen clickTshirtProduct(){
        tShirtProductName.click();
        return new ProductInfoScreen();
    }

    public ProductInfoScreen clickOnesieProduct(){
        onesieProductName.click();
        return new ProductInfoScreen();
    }

    public HomeScreen scrollScreen(){
        MobileActions.scroll();
        return new HomeScreen();
    }

    public HomeScreen scrollScreenForOnesieProduct(){
        MobileActions.scrollForElement(onesieProductName, 30);
        return new HomeScreen();
    }

}
