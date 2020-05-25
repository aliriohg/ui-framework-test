package com.store.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;


public class ButtonContainerPage {

    LayerCartPage layerCartPage;
    LayerItemPage layerItemPage;
    WebDriverWait wait;

    private WebElement caption;
    private By buttonAddToCart = By.xpath("//span[contains(text(),'Add to cart')]");
    private By buttonMore = By.xpath("//span[contains(text(),'More')]");
    private By buttonQuickView = By.xpath("//div[@class='product-container']//a[@class='quick-view']");


    public ButtonContainerPage(WebElement caption) {
        this.caption = caption;
    }

    public LayerCartPage clickOnAddCart() {
        caption.findElement(buttonAddToCart).click();
        return layerCartPage;
    }

    public LayerItemPage clickOnMore() {
        caption.findElement(buttonMore).click();
        return layerItemPage;
    }

    public void clickOnQuickView() {
        caption.findElement(buttonQuickView).click();
    }
}