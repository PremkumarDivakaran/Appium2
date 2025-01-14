package com.saucelab.test;

import com.saucelab.screens.HomeScreen;
import org.testng.annotations.Test;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class SauceLabTest extends BaseTest {

    @Test
    public void checkBackPackProductPriceAfterCheckout() {
        HomeScreen homeScreen = launchApp();
        String productPrice = homeScreen.getBackPackProductPrice();
        String totalPrice =  homeScreen
                .clickBackPackProduct()
                .clickAddToCart()
                .openCart()
                .getTotalPrice();
        assertThat(productPrice).isEqualTo(totalPrice);
    }

    //@Test
    public void checkTshirtProductPriceAfterCheckout() {
        HomeScreen homeScreen = launchApp();
        String productPrice = homeScreen.getTshirtProductPrice();
        String totalPrice =  homeScreen
                .clickTshirtProduct()
                .clickAddToCart()
                .openCart()
                .getTotalPrice();
        assertThat(productPrice).isEqualTo(totalPrice);
    }

    //@Test
    public void checkOnesieProductPriceAfterCheckout() {
        HomeScreen homeScreen = launchApp();
        homeScreen.scrollScreen();
        String productPrice = homeScreen.getOnesieProductPrice();
        String totalPrice =  homeScreen
                .clickOnesieProduct()
                .clickAddToCart()
                .openCart()
                .getTotalPrice();
        assertThat(productPrice).isEqualTo(totalPrice);
    }

    //@Test
    public void scrollAndCheckOnesieProductPriceAfterCheckout() {
        HomeScreen homeScreen = launchApp();
        homeScreen.scrollScreenForOnesieProduct();
        String productPrice = homeScreen.getOnesieProductPrice();
        String totalPrice =  homeScreen
                .clickOnesieProduct()
                .clickAddToCart()
                .openCart()
                .getTotalPrice();
        assertThat(productPrice).isEqualTo(totalPrice);
    }

}
