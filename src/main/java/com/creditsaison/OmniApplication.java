package com.creditsaison;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;

/**
 * Hello world!
 *
 */
@SpringBootApplication
@EntityScan(basePackages = "com.creditsaison")
public class OmniApplication {
    public static void main( String[] args ) {

        SpringApplication.run(OmniApplication.class, args);
    }
}
