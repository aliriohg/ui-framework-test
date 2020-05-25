package com.store.conf;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.PropertySource;

@ComponentScan(basePackages = "com.store")
@PropertySource("classpath:/configuration.properties")
public class TestConfig {
}
