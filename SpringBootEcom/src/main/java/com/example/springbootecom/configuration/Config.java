package com.example.springbootecom.configuration;

import com.example.springbootecom.common.AuditorAwareImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.domain.AuditorAware;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@Configuration
@EnableJpaAuditing(auditorAwareRef = "stringAuditorAware")
public class Config {

    @Bean
    public AuditorAware<String> stringAuditorAware(){
        return new AuditorAwareImpl();
    }

}
