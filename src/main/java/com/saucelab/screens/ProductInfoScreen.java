package com.saucelab.screens;

import io.appium.java_client.pagefactory.AndroidFindBy;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import static com.saucelab.driver.DriverInstance.getDriver;


public class ProductInfoScreen {

    @AndroidFindBy(accessibility = "Add To Cart button")
    private WebElement addToCart;
    By addToCartBtn = By.xpath("//android.widget.TextView[@text=\"Add To Cart\"]");

    @AndroidFindBy(xpath = "//android.view.ViewGroup[@content-desc=\"cart badge\"]/android.widget.ImageView")
    private WebElement openCart;
    By openCartIcon = By.xpath("//android.view.ViewGroup[@content-desc=\"cart badge\"]/android.widget.ImageView");

    public ProductInfoScreen clickAddToCart(){
        getDriver().findElement(addToCartBtn).click();
        //$(addToCart).shouldBe(visible).click();
        return this;
    }

    public CheckOutScreen openCart(){
        getDriver().findElement(openCartIcon).click();
        //$(openCart).shouldBe(visible).click();
        return new CheckOutScreen();
    }

}
