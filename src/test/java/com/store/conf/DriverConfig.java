package com.store.conf;

import com.store.enums.Browser;
import com.store.util.driver.DriverFactory;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

import java.net.MalformedURLException;
import java.time.Duration;

@Configuration
public class DriverConfig {

    @Value("${driver}")
    private Browser driverType;

    @Autowired
    private DriverFactory driverFactory;

    @Scope("cucumber-glue")
    @Bean(destroyMethod = "quit")
    public WebDriver webDriver() throws MalformedURLException {
        return driverFactory.get(driverType);
    }

    @Bean
    @Scope("cucumber-glue")
    public WebDriverWait waitFor() throws MalformedURLException {
        return new WebDriverWait(webDriver(), Duration.ofSeconds(5));
    }


}
