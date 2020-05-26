package com.store.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Scope("cucumber-glue")
@Component
public class ButtonContainerPage extends PageBase {

    @Autowired
    LayerCartPage layerCartPage;
    @Autowired
    LayerItemPage layerItemPage;

    private By buttonAddToCart = By.xpath("//span[contains(text(),'Add to cart')]");
    private By buttonMore = By.xpath("//span[contains(text(),'More')]");
    private By buttonQuickView = By.xpath("//div[@class='product-container']//a[@class='quick-view']");

    @Autowired
    public ButtonContainerPage(WebDriver driver) {
        super(driver);
    }


    public LayerCartPage clickOnAddCart() {
        driver.findElement(buttonAddToCart).click();
        return layerCartPage;
    }

    public LayerItemPage clickOnMore() {
        driver.findElement(buttonMore).click();
        return layerItemPage;
    }

    public void clickOnQuickView() {
        driver.findElement(buttonQuickView).click();
    }
}