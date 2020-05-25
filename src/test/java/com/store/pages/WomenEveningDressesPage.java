package com.store.pages;

import com.store.util.UtilsActionPages;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Scope("cucumber-glue")
@Component
public class WomenEveningDressesPage extends PageBase {
    private By printedDressItem = By.xpath("//div[@class='right-block']//a[@class='product-name'][contains(text(),'Printed Dress')]");
    private By iframeItem = By.className("fancybox-iframe");
    @Autowired
    UtilsActionPages utilsActionPages;
    @Autowired
    private WebDriverWait wait;
    @Autowired
    LayerItemPage layerItemPage;
    @Autowired
    LayerCartPage layerCartPage;

    @Autowired
    public WomenEveningDressesPage(WebDriver driver) {
        super(driver);
    }


    public LayerItemPage clickOnQuickViewOfPrintedDress() {
        utilsActionPages.hoverOverButtonContainer(driver.findElement(printedDressItem))
                .clickOnQuickView();
        wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(driver.findElement(iframeItem)));
        return layerItemPage;
    }

    public LayerCartPage clickOnPrintedDressAddtoCart() {
        utilsActionPages.hoverOverButtonContainer(driver.findElement(printedDressItem))
                .clickOnAddCart();
        return layerCartPage;
    }

    public LayerItemPage clickOnPrintedDressMore() {
        utilsActionPages.hoverOverButtonContainer(driver.findElement(printedDressItem))
                .clickOnMore();
        return layerItemPage;
    }


}
