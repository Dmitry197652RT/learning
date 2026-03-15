package com.example.demo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestClient;

@Configuration
public class AppConfig {

    @Bean
    public RestClient restClient(){

    // урл вынести в отдельный класс констант в папку константы в отдельный файл рестклиентконстантс
        return RestClient.builder()
                .baseUrl("https://jsonplaceholder.typicode.com/")
                .build();
    }
}
