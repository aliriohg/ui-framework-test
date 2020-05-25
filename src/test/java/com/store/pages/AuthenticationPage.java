package com.store.pages;

import org.openqa.selenium.WebDriver;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Scope("cucumber-glue")
@Component
public class AuthenticationPage extends PageBase{
    public AuthenticationPage(WebDriver driver) {
        super(driver);
    }
}
