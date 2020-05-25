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
public class LayerCartPage extends PageBase {
    private By buttonContinueShopping = By.xpath("//span[@title='Continue shopping']//span");
    private By layerMessage = By.xpath("//div[@class='layer_cart_product col-xs-12 col-md-6']//h2[1]");

    @Autowired
    private HomePage homePage;
    @Autowired
    private WebDriverWait wait;

    @Autowired
    public LayerCartPage(WebDriver driver) {
        super(driver);
    }

    public HomePage clickContinueShopping() {
        wait.until(ExpectedConditions.elementToBeClickable(buttonContinueShopping));
        driver.findElement(buttonContinueShopping).click();
        return homePage;
    }

    public String getLayerMessage() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(layerMessage));
        return driver.findElement(layerMessage).getText();
    }

}
