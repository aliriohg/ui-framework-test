package com.store.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;


@Scope("cucumber-glue")
@Component
public class HomePage extends PageBase {

    private By shoppingCart = By.xpath("//div[@class='shopping_cart']//a[@title='View my shopping cart']");
    @Autowired
    ShoppingCartSummary shoppingCartSummary;

    @Autowired
    public HomePage(WebDriver webDriver) {
        super(webDriver);
    }

    public WomenPage goToWomenPage() {
        clickLinkText("Women");
        return new WomenPage(driver);
    }

    private void clickLinkText(String linkText) {
        driver.findElement(By.linkText(linkText)).click();
    }

    public ShoppingCartSummary clickToCart() {
        driver.findElement(shoppingCart).click();
        return shoppingCartSummary;
    }
}
