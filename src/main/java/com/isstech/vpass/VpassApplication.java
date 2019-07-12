package com.isstech.vpass;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class VpassApplication {

    public static void main(String[] args) {
        SpringApplication.run(VpassApplication.class, args);
    }

}
