package org.example;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Hello world!
 *
 */
@OpenAPIDefinition(info = @Info(title = "SpringBootEcom album-order-service",version = "SNAPSHOT",description = "Using Spring Boot 3"))
@SpringBootApplication
public class SpringBootMongoDBApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringBootMongoDBApplication.class, args);
    }

}
