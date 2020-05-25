package com.store.pages;


import com.store.util.UtilsActionPages;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Scope("cucumber-glue")
@Component
public class WomenBlousesPage extends PageBase {
    private By blouseItem = By.xpath("//div[@class='right-block']//a[@class='product-name'][contains(text(),'Blouse')]");

    @Autowired
    UtilsActionPages utilsActionPages;
    @Autowired
    public WomenBlousesPage(WebDriver driver) {
        super(driver);
    }

    public LayerCartPage addBlouseToCart() {
        return utilsActionPages.hoverOverButtonContainer(driver.findElement(blouseItem))
                .clickOnAddCart();
    }

    public LayerItemPage blouseClickOnMore(){
        return utilsActionPages.hoverOverButtonContainer(driver.findElement(blouseItem))
                .clickOnMore();
    }

}
