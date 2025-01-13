package com.saucelab.screens;

import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import org.openqa.selenium.WebElement;


public class ProductInfoScreen extends BaseScreen {

    @AndroidFindBy(accessibility = "Add To Cart button")
    @iOSXCUITFindBy(accessibility = "Add To Cart button")
    private WebElement addToCart;

    @AndroidFindBy(xpath = "//android.view.ViewGroup[@content-desc=\"cart badge\"]/android.widget.ImageView")
    @iOSXCUITFindBy(accessibility = "tab bar option cart")
    private WebElement openCart;

    public ProductInfoScreen clickAddToCart(){
        addToCart.click();
        return this;
    }

    public CheckOutScreen openCart(){
        openCart.click();
        return new CheckOutScreen();
    }

}
