package com.store.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Scope("cucumber-glue")
@Component
public class WomenDressesPage extends PageBase {
    private By eveningDressesCategory = By.xpath("//div[@class='block_content']//ul[@class='tree dynamized']//a[contains(text(),'Evening Dresses')]");

    @Autowired
    WomenEveningDressesPage womenEveningDressesPage;
    @Autowired
    WebDriverWait wait;

    @Autowired
    public WomenDressesPage(WebDriver driver) {
        super(driver);
    }

    public WomenEveningDressesPage clickOnEveningDresses() {
        wait.until(ExpectedConditions.elementToBeClickable(eveningDressesCategory));
        driver.findElement(eveningDressesCategory).click();
        return womenEveningDressesPage;
    }
}
