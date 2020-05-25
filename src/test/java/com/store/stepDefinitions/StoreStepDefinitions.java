package com.store.stepDefinitions;

import com.store.pages.*;
import com.store.task.NavigateTo;
import com.store.util.PageManager;
import io.cucumber.java8.En;
import org.openqa.selenium.WebDriver;
import org.springframework.beans.factory.annotation.Autowired;

import static org.junit.jupiter.api.Assertions.*;

public class StoreStepDefinitions implements En {

    @Autowired
    NavigateTo navigateTo;
    @Autowired
    HomePage homePage;
    @Autowired
    WomenPage womenPage;
    @Autowired
    WomenTopsPage womenTopsPage;
    @Autowired
    WomenBlousesPage womenBlousesPage;
    @Autowired
    LayerItemPage layerItemPage;
    @Autowired
    PageManager pageManager;
    @Autowired
    LayerCartPage layerCartPage;
    @Autowired
    WomenDressesPage womenDressesPage;
    @Autowired
    WomenEveningDressesPage womenEveningDressesPage;
    @Autowired
    ShoppingCartSummary shoppingCartSummary;

    public StoreStepDefinitions() {
        Given("^the user is on Homepage$", () -> {
            navigateTo.goToHomePage();
        });
        And("^the user clicks Women$", () -> {
            homePage.goToWomenPage();
        });
        And("^user clicks Tops$", () -> {
            womenPage.clickOnTopsCategory();
        });
        And("^User Clicks blouses$", () -> {
            womenTopsPage.clickOnBlousesCategory();
        });
        And("^user clicks on add to cart$", () -> {
            womenBlousesPage.addBlouseToCart();
        });
        When("^the user clicks on continue shopping$", () -> {
            layerCartPage.clickContinueShopping();
        });
        Then("^the user is returned to the homepage$", () -> {
            assertEquals(pageManager.getTitle(), "My Store", "the user is not in homepage");
            assertEquals(pageManager.getCurrenUrlPage(), "http://automationpractice.com/index.phpl", "the user is not in homepage");
        });
        And("^user clicks Dresses$", () -> {
            womenPage.clickOnDressesCategory();
        });
        And("^User Clicks evening dresses$", () -> {
            womenDressesPage.clickOnEveningDresses();
        });
        And("^user clicks on \\(Quick View\\) printed dress$", () -> {
            womenEveningDressesPage.clickOnQuickViewOfPrintedDress();
        });
        And("^user clicks on add to cart from Pop up$", () -> {
            layerItemPage.addItemToCartFromPopUp();
        });
        And("^the user clicks Cart$", () -> {
            homePage.clickToCart();
        });
        And("^the cart has (\\d+) products$", (Integer totalItems) -> {
            assertEquals(shoppingCartSummary.numberOfProductsInTheCart(), 2, "the cart doesn't have " + totalItems + " products");
        });
        When("^User Clicks checkout$", () -> {
            shoppingCartSummary.clickToCheckout();
        });
        Then("^user is taken to the Authentication screen$", () -> {
            assertEquals(pageManager.getTitle(),"Login - My Store","the user is not in login page");
        });
    }
}
