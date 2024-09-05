package org.screens.SauceLab;

import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import org.openqa.selenium.WebElement;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;

public class CheckOutScreen {

    @AndroidFindBy(xpath = "//android.widget.TextView[@content-desc=\"total price\"]")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"total price\"]")
    private WebElement totalPrice;

    public String getTotalPrice(){
        return $(totalPrice).shouldBe(visible).getText();
    }
}
