package com.nasaexampleproject.nasaexampleapi.springconfig;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class ActivitySpringConfig {

	@Bean
    public RestTemplate restTemplate () {
        return new RestTemplate();
    } 
}
