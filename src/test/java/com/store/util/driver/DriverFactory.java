package com.store.util.driver;

import com.store.enums.Browser;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;


@Component
public class DriverFactory {

    public WebDriver get(Browser browser) {
        WebDriver driver;
        switch (browser) {
            case chrome:
                WebDriverManager.chromedriver().setup();
                driver = new ChromeDriver();
                break;
            case firefox:
                WebDriverManager.firefoxdriver().setup();
                driver = new FirefoxDriver();
                break;
            default:
                throw new IllegalArgumentException("Driver not found for browser: " + browser);
        }

        driver.manage().window().maximize();
        return driver;
    }


}
