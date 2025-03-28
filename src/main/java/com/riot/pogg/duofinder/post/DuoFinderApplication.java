package com.riot.pogg.duofinder.post;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = "com.riot.pogg.duofinder")
public class DuoFinderApplication {

    public static void main(String[] args) {
        SpringApplication.run(DuoFinderApplication.class, args);
    }
}
