package com.example.ajopay;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@EnableScheduling
@SpringBootApplication
public class AjopayApplication {

    public static void main(String[] args) {
        SpringApplication.run(AjopayApplication.class, args);
    }

}
