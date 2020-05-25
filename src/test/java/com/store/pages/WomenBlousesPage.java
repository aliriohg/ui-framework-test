package com.store.pages;


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
    private By boxButton = By.xpath("//div[@class='right-block']//div[@class='button-container']");

    @Autowired
    private LayerItemPage layerItemPage;

    @Autowired
    public WomenBlousesPage(WebDriver driver) {
        super(driver);
    }

    public ButtonContainer hoverOverBlouse() {
        WebElement blouse = driver.findElement(blouseItem);
        Actions actions = new Actions(driver);
        actions.moveToElement(blouse).perform();
        return new ButtonContainer(blouse.findElement(boxButton));
    }

    public LayerItemPage clickOnBlouseItem() {
        hoverOverBlouse();
        driver.findElement(blouseItem).click();
        return layerItemPage;
    }

    public LayerCartPage addBlouseToCart(){
       return hoverOverBlouse()
               .clickOnAddCart();
    }

    public class ButtonContainer {
        @Autowired
        LayerCartPage layerCartPage;
        private WebElement caption;
        private By buttonAddToCart = By.xpath("//span[contains(text(),'Add to cart')]");

        public ButtonContainer(WebElement caption) {
            this.caption = caption;
        }

        public LayerCartPage clickOnAddCart() {
            caption.findElement(buttonAddToCart).click();
            return layerCartPage;
        }
    }
}
