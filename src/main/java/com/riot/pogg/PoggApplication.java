package com.riot.pogg;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication(scanBasePackages = "com.riot.pogg.duofinder")
@EnableScheduling // 스케줄링 활성화
public class PoggApplication {

	public static void main(String[] args) {
		SpringApplication.run(PoggApplication.class, args);
	}
}
