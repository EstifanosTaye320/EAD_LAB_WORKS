package com.labexam.application;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@SpringBootApplication
@ServletComponentScan("com.labexam")
@Configuration
@ComponentScan("com.labexam")
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
}
