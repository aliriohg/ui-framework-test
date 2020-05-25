package com.store.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Scope("cucumber-glue")
@Component
public class WomenTopsPage extends PageBase{

    private By blousesCategory = By.xpath("//div[@class='block_content']//ul[@class='tree dynamized']//a[contains(text(),'Blouses')]");
    @Autowired
    private WomenBlousesPage womenBlousesPage;

    @Autowired
    public WomenTopsPage(WebDriver driver) {
        super(driver);
    }
    public WomenBlousesPage clickOnBlousesCategory(){
        driver.findElement(blousesCategory).click();
        return womenBlousesPage;
    }

}
