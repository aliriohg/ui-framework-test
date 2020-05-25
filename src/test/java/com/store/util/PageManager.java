package com.store.util;

import com.store.pages.PageBase;
import org.openqa.selenium.WebDriver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Scope("cucumber-glue")
@Component
public class PageManager extends PageBase {

    @Autowired
    public PageManager(WebDriver driver) {
        super(driver);
    }

    public String getTitle(){
        return driver.getTitle();
    }
    public String getCurrenUrlPage(){
        return driver.getCurrentUrl();
    }



}
