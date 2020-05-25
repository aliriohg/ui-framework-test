package com.store.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.time.Duration;

@Scope("cucumber-glue")
@Component
public class WomenPage extends PageBase {
    private String xpathCategory = "//div[@class='block_content']//ul[@class='tree dynamized']";
    private By topsCategory = By.xpath(xpathCategory + "//a[contains(text(),'Tops')]");
    private By dressesCategory = By.xpath(xpathCategory + "//a[contains(text(),'Dresses')]");
    @Autowired
    private WebDriverWait wait;
    @Autowired
    WomenDressesPage womenDressesPage;
    @Autowired
    private WomenTopsPage womenTopsPage;

    @Autowired
    public WomenPage(WebDriver driver) {
        super(driver);
    }

    public WomenTopsPage clickOnTopsCategory() {
        wait.until(ExpectedConditions.elementToBeClickable(topsCategory));
        driver.findElement(topsCategory).click();
        return womenTopsPage;
    }

    public WomenDressesPage clickOnDressesCategory() {
        wait.until(ExpectedConditions.elementToBeClickable(dressesCategory));
        driver.findElement(dressesCategory)
                .click();
        return womenDressesPage;
    }
}
