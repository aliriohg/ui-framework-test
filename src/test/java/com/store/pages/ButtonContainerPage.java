package com.store.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.springframework.beans.factory.annotation.Autowired;

public class ButtonContainerPage {

    @Autowired
    LayerCartPage layerCartPage;
    @Autowired
    LayerItemPage layerItemPage;

    private WebElement caption;
    private By buttonAddToCart = By.xpath("//span[contains(text(),'Add to cart')]");
    private By buttonMore = By.xpath("//span[contains(text(),'More')]");


    public ButtonContainerPage(WebElement caption) {
        this.caption = caption;
    }

    public LayerCartPage clickOnAddCart() {
        caption.findElement(buttonAddToCart).click();
        return layerCartPage;
    }
    public LayerItemPage clickOnMore(){
        caption.findElement(buttonMore).click();
        return layerItemPage;
    }
}