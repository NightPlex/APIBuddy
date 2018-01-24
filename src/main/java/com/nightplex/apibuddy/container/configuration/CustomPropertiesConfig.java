package com.nightplex.apibuddy.container.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;

/**
 * Created by steven.tihomirov on 24.1.2018
 */

@Configuration
@PropertySource("classpath:project.properties")
public class CustomPropertiesConfig {

    @Bean
    public static PropertySourcesPlaceholderConfigurer propertySourcesPlaceholderConfigurer () {
        return new PropertySourcesPlaceholderConfigurer();
    }
}
