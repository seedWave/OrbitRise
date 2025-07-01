package com.orbitRise.backend.config;


import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@EntityScan(basePackages = {"com.synapse.backend"})
public class JPAConfiguration {
}
