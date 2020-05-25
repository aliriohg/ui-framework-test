package com.store.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.time.Duration;

@Scope("cucumber-glue")
@Component
public class LayerItemPage extends PageBase {
    private By buttonAddToCart = By.xpath("//button[@name='Submit']//span[contains(text(),'Add to cart')]");
    @Autowired
    private LayerCartPage layerCartPage;
    @Autowired
    private WebDriverWait wait;

    @Autowired
    public LayerItemPage(WebDriver driver) {
        super(driver);
    }

    public LayerCartPage addItemToCart() {
        wait.until(ExpectedConditions.elementToBeClickable(buttonAddToCart));
        driver.findElement(buttonAddToCart).click();
        return layerCartPage;
    }

    public LayerCartPage addItemToCartFromPopUp() {
        wait.until(ExpectedConditions.elementToBeClickable(buttonAddToCart));
        driver.findElement(buttonAddToCart).click();
        driver.switchTo().parentFrame();
        return layerCartPage;
    }
}
