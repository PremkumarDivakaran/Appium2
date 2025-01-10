package org.screens.SauceLab;

import io.appium.java_client.pagefactory.AndroidFindBy;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import static org.driver.DriverInstance.getDriver;


public class HomeScreen {

    /*@AndroidFindBy(xpath = "//android.widget.TextView[@content-desc=\"store item text\" and @text=\"Sauce Labs Backpack\"]")
    private WebElement sauceLabProductName;*/
    By backPackProductName= By.xpath("//android.widget.TextView[@content-desc=\"store item text\" and @text=\"Sauce Labs Backpack\"]");
    By tShirtProductName= By.xpath("//android.widget.TextView[@content-desc=\"store item text\" and @text=\"Sauce Labs Bolt T-Shirt\"]");

    /*@AndroidFindBy(xpath = "//android.widget.TextView[@content-desc=\"store item text\" and @text=\"Sauce Labs Backpack\"]/../following-sibling::android.widget.TextView")
    private WebElement sauceLabProductPrice;*/
    By backPackProductPrice = By.xpath("//android.widget.TextView[@content-desc=\"store item text\" and @text=\"Sauce Labs Backpack\"]/../following-sibling::android.widget.TextView");
    By tShirtProductPrice = By.xpath("//android.widget.TextView[@content-desc=\"store item text\" and @text=\"Sauce Labs Bolt T-Shirt\"]/../following-sibling::android.widget.TextView");

    public String getBackPackProductPrice(){
        return getDriver().findElement(backPackProductPrice).getText();
        //return $(sauceLabProductPrice).shouldBe(visible).getText();
    }

    public String getTshirtProductPrice(){
        return getDriver().findElement(tShirtProductPrice).getText();
        //return $(sauceLabProductPrice).shouldBe(visible).getText();
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

}
