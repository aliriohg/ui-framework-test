package com.store.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.springframework.beans.factory.annotation.Autowired;

public class ButtonContainerPage {

    @Autowired
    LayerCartPage layerCartPage;
    @Autowired
    LayerItemPage layerItemPage;
    @Autowired
    WebDriverWait wait;
    private WebElement caption;
    private By buttonAddToCart = By.xpath("//span[contains(text(),'Add to cart')]");
    private By buttonMore = By.xpath("//span[contains(text(),'More')]");
    private By buttonQuickView = By.className("quick-view");


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
        wait.until(ExpectedConditions.visibilityOf(
                caption.findElement(buttonQuickView)));
        caption.findElement(buttonQuickView).click();
    }
}