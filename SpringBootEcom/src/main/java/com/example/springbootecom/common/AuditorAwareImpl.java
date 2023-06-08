package com.example.springbootecom.common;

import org.springframework.data.domain.AuditorAware;

import java.util.Optional;

public class AuditorAwareImpl implements AuditorAware<String> {
    @Override
    public Optional<String> getCurrentAuditor() {
        //SecurityContextHolder
        //get Principal
        //get User
        return Optional.of("Saroj");
    }
}
