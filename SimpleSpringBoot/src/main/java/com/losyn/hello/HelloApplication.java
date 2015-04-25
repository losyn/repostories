package com.losyn.hello;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * SpringBoot Ö÷³ÌÐò
 */
@SpringBootApplication
public class HelloApplication implements CommandLineRunner {
    public static void main(String[] args) {
        SpringApplication.run(HelloApplication.class, args);
    }

    public void run(String... args) throws Exception {
        System.out.println("input Ctrl-C to end this application");
        Thread.currentThread().join();
    }
}
