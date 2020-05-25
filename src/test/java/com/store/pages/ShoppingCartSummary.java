package com.store.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Scope("cucumber-glue")
@Component
public class ShoppingCartSummary extends PageBase {

    private By productItemColumn = By.className("cart_product");
    private By buttonCheckout = By.xpath("//a[@class='button btn btn-default standard-checkout button-medium']//span[contains(text(),'Proceed to checkout')]");
    @Autowired
    WebDriverWait wait;
    @Autowired
    AuthenticationPage authenticationPage;

    @Autowired
    public ShoppingCartSummary(WebDriver driver) {
        super(driver);
    }

    public int numberOfProductsInTheCart() {
        return driver.findElements(productItemColumn).size()-1;
    }

    public AuthenticationPage clickToCheckout() {
        wait.until(ExpectedConditions.elementToBeClickable(buttonCheckout));
        driver.findElement(buttonCheckout).click();
        return authenticationPage;
    }
}
