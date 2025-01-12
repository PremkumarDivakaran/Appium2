package com.saucelab.screens;

import com.saucelab.actions.MobileActions;
import org.openqa.selenium.By;

import static com.saucelab.driver.DriverInstance.getDriver;


public class HomeScreen {

    /*@AndroidFindBy(xpath = "//android.widget.TextView[@content-desc=\"store item text\" and @text=\"Sauce Labs Backpack\"]")
    private WebElement sauceLabProductName;*/
    By backPackProductName= By.xpath("//android.widget.TextView[@content-desc=\"store item text\" and @text=\"Sauce Labs Backpack\"]");
    By tShirtProductName= By.xpath("//android.widget.TextView[@content-desc=\"store item text\" and @text=\"Sauce Labs Bolt T-Shirt\"]");
    By onesieProductName= By.xpath("//android.widget.TextView[@content-desc=\"store item text\" and @text=\"Sauce Labs Onesie\"]");

    /*@AndroidFindBy(xpath = "//android.widget.TextView[@content-desc=\"store item text\" and @text=\"Sauce Labs Backpack\"]/../following-sibling::android.widget.TextView")
    private WebElement sauceLabProductPrice;*/
    By backPackProductPrice = By.xpath("//android.widget.TextView[@content-desc=\"store item text\" and @text=\"Sauce Labs Backpack\"]/../following-sibling::android.widget.TextView");
    By tShirtProductPrice = By.xpath("//android.widget.TextView[@content-desc=\"store item text\" and @text=\"Sauce Labs Bolt T-Shirt\"]/../following-sibling::android.widget.TextView");
    By onesieProductPrice = By.xpath("//android.widget.TextView[@content-desc=\"store item text\" and @text=\"Sauce Labs Onesie\"]/../following-sibling::android.widget.TextView");

    public String getBackPackProductPrice(){
        return getDriver().findElement(backPackProductPrice).getText();
        //return $(sauceLabProductPrice).shouldBe(visible).getText();
    }

    public String getTshirtProductPrice(){
        return getDriver().findElement(tShirtProductPrice).getText();
        //return $(sauceLabProductPrice).shouldBe(visible).getText();
    }

    public String getOnesieProductPrice(){
        return getDriver().findElement(onesieProductPrice).getText();
    }

    public ProductInfoScreen clickBackPackProduct(){
        getDriver().findElement(backPackProductName).click();
        //$(sauceLabProductName).shouldBe(visible).click();
        return new ProductInfoScreen();
    }

    public ProductInfoScreen clickTshirtProduct(){
        getDriver().findElement(tShirtProductName).click();
        return new ProductInfoScreen();
    }

    public ProductInfoScreen clickOnesieProduct(){
        getDriver().findElement(onesieProductName).click();
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
