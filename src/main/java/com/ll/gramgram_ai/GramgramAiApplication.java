package com.ll.gramgram_ai;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing

public class GramgramAiApplication {

    public static void main(String[] args) {
        SpringApplication.run(GramgramAiApplication.class, args);
    }

}
