package com.prerna.productcatalogservice2704.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class RestTemplateConfig {

    @Bean
    public RestTemplate getRestemplate(){
        return new RestTemplate();
    }
}
