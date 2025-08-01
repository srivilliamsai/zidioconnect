package com.zidio.zidioconnect;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class ZidioconnectApplication {
    public static void main(String[] args) {
        SpringApplication.run(ZidioconnectApplication.class, args);
    }
}
