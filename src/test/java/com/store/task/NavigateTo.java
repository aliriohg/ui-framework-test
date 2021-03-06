package com.store.task;

import org.openqa.selenium.WebDriver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;


@Scope("cucumber-glue")
@Component
public class NavigateTo {

    @Autowired
    private WebDriver webDriver;

    @Value("${url.home}")
    private String homePage;

    @Value("${url.blouse.section}")
    private String blousesPage;

    @Value("${url.eveningdress.section}")
    private String eveningDressPage;

    public void goToHomePage(){
        this.webDriver.get(homePage);
    }

    public void goToBlousePage() {
        this.webDriver.get(blousesPage);
    }
    public void goToEveningDress() {
        this.webDriver.get(eveningDressPage);
    }
}
