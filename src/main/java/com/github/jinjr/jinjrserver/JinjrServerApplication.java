package com.github.jinjr.jinjrserver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories
@EnableJpaAuditing
public class JinjrServerApplication {

    public static void main(String[] args) {
        SpringApplication.run(JinjrServerApplication.class, args);
    }

}
