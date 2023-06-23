package com.exam.ekaterine_gurgenidze;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class JavaBookingApiOption3Application {

    public static void main(String[] args) {
        SpringApplication.run(JavaBookingApiOption3Application.class, args);
    }

}
