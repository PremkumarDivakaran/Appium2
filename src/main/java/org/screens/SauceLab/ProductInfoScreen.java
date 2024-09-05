package org.screens.SauceLab;

import io.appium.java_client.pagefactory.AndroidFindBy;
import org.openqa.selenium.WebElement;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.appium.ScreenObject.screen;

public class ProductInfoScreen {

    @AndroidFindBy(accessibility = "Add To Cart button")
    private WebElement addToCart;

    @AndroidFindBy(xpath = "//android.view.ViewGroup[@content-desc=\"cart badge\"]/android.widget.ImageView")
    private WebElement openCart;

    public ProductInfoScreen clickAddToCart(){
        $(addToCart).shouldBe(visible).click();
        return screen(ProductInfoScreen.class);
    }

    public CheckOutScreen openCart(){
        $(openCart).shouldBe(visible).click();
        return screen(CheckOutScreen.class);
    }


}
