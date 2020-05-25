package com.store.util;

import com.store.pages.ButtonContainerPage;
import com.store.pages.PageBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Scope("cucumber-glue")
@Component
public class UtilsActionPages extends PageBase {
    private By productContainer = By.xpath("//div[@class='product-container']");

    @Autowired
    public UtilsActionPages(WebDriver driver) {
        super(driver);
    }

    public ButtonContainerPage hoverOverButtonContainer(WebElement webElement) {
        Actions actions = new Actions(driver);
        actions.moveToElement(webElement).perform();
        return new ButtonContainerPage(webElement.findElement(productContainer));
    }
}
