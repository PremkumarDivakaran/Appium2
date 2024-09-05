package org.screens.SauceLab;

import static com.codeborne.selenide.Condition.visible;

import static com.codeborne.selenide.appium.ScreenObject.screen;

import com.codeborne.selenide.appium.AppiumSelectors;
import com.codeborne.selenide.appium.selector.CombinedBy;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.time.Duration;

import static com.codeborne.selenide.Selenide.$;

public class HomeScreen {

    By productAndroid = AppiumSelectors.withTagAndText("android.widget.TextView", "Sauce Labs Backpack");

    //@AndroidFindBy(xpath = "//android.widget.TextView[@content-desc=\"store item text\" and @text=\"Sauce Labs Backpack\"]")
    //private WebElement productName;

    @AndroidFindBy(xpath = "//android.widget.TextView[@content-desc=\"store item text\" and @text=\"Sauce Labs Backpack\"]/../following-sibling::android.widget.TextView")
    private WebElement productPrice;

    public String getProductPrice(){
        return $(productPrice).shouldBe(visible).getText();
    }

    public ProductInfoScreen clickProduct(){
        CombinedBy productName = CombinedBy.android(productAndroid);
        $(productName).shouldBe(visible).click();
        return screen(ProductInfoScreen.class);
    }

}
