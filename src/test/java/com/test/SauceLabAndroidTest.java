package com.test;

import org.driver.DriverInstance;
import org.framework.PlatformType;
import org.screens.SauceLab.HomeScreen;
import org.testng.annotations.Test;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class SauceLabAndroidTest extends BaseTest {

    @Test
    public void checkBackPackProductPriceAfterCheckout() {
        HomeScreen homeScreen = new HomeScreen();
        String productPrice = homeScreen.getBackPackProductPrice();
        String totalPrice =  homeScreen
                .clickBackPackProduct()
                .clickAddToCart()
                .openCart()
                .getTotalPrice();
        assertThat(productPrice).isEqualTo(totalPrice);
    }

    @Test
    public void checkTshirtProductPriceAfterCheckout() {
        HomeScreen homeScreen = new HomeScreen();
        String productPrice = homeScreen.getTshirtProductPrice();
        String totalPrice =  homeScreen
                .clickTshirtProduct()
                .clickAddToCart()
                .openCart()
                .getTotalPrice();
        assertThat(productPrice).isEqualTo(totalPrice);
    }

}
