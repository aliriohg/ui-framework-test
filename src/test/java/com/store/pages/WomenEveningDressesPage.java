package com.store.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.time.Duration;

@Scope("cucumber-glue")
@Component
public class WomenEveningDressesPage extends PageBase {
    private By printedDressItem = By.xpath("//div[@class='right-block']//a[@class='product-name'][contains(text(),'Printed Dress')]");
    private By productContainer = By.xpath("//div[@class='product-container']");
    private By iframeItem= By.className("fancybox-iframe");
    @Autowired
    private WebDriverWait wait;

    @Autowired
    LayerItemPage layerItemPage;

    @Autowired
    public WomenEveningDressesPage(WebDriver driver) {
        super(driver);
    }

    public QuickViewContainer hoverOver(WebElement webElement) {
        Actions actions = new Actions(driver);
        actions.moveToElement(webElement).perform();
        return new QuickViewContainer(webElement.findElement(productContainer));
    }

    public LayerItemPage clickOnQuickViewOfPrintedDress() {
        hoverOver(driver.findElement(printedDressItem))
                .clickOnQuickView();
        wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(driver.findElement(iframeItem)));
        return layerItemPage;
    }

    public class QuickViewContainer {
        private WebElement caption;
        private By buttonQuickView = By.className("quick-view");

        public QuickViewContainer(WebElement caption) {
            this.caption = caption;
        }

        public void clickOnQuickView() {
            wait.until(ExpectedConditions.visibilityOf(
                    caption.findElement(buttonQuickView)));
            caption.findElement(buttonQuickView).click();
        }
    }

}
