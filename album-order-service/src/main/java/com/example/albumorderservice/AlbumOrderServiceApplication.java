package com.example.albumorderservice;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@OpenAPIDefinition(info = @Info(title = "SpringBootEcom album-order-service",version = "SNAPSHOT",description = "Using Spring Boot 3"))
@SpringBootApplication
public class AlbumOrderServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(AlbumOrderServiceApplication.class, args);
    }

}
