package com.store;

import com.store.conf.TestConfig;
import io.cucumber.java.Before;
import io.cucumber.spring.CucumberContextConfiguration;
import org.springframework.boot.test.context.SpringBootContextLoader;
import org.springframework.test.context.ContextConfiguration;

@CucumberContextConfiguration
@ContextConfiguration(classes = {TestConfig.class, StartApplication.class}, loader = SpringBootContextLoader.class)
public class CucumberSpringContextConfiguration {

    @Before
    public void setup(){
        System.out.println("Context started!");
    }
}
