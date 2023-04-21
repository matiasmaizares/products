package com.example.challengue;

import org.springdoc.core.models.GroupedOpenApi;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class ChallengueApplication {

    public static void main(String[] args) {
        SpringApplication.run(ChallengueApplication.class, args);
    }
    @Bean
    public GroupedOpenApi publicApi() {
        return GroupedOpenApi.builder()
                .group("spring-public")
                .packagesToScan("com.example")
                .build();
    }
}
