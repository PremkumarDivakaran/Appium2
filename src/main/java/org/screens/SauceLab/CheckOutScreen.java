package org.screens.SauceLab;

import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import static org.driver.DriverInstance.getDriver;


public class CheckOutScreen {

    @AndroidFindBy(xpath = "//android.widget.TextView[@content-desc=\"total price\"]")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"total price\"]")
    private WebElement totalPrice;
    By finalPrice = By.xpath("//android.widget.TextView[@content-desc=\"total price\"]");

    public String getTotalPrice(){
        return getDriver().findElement(finalPrice).getText();
        //return $(totalPrice).shouldBe(visible).getText();
    }
}
