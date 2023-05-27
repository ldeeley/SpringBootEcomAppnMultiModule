package com.example.springbootecom;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@OpenAPIDefinition(info = @Info(title = "SpringBootEcom Appn",version = "SNAPSHOT",description = "Using Spring Boot 3"))
public class SpringBootEcomApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringBootEcomApplication.class, args);
    }

}
