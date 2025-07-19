package com.zidio.zidioconnect;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@EnableDiscoveryClient
@SpringBootApplication
public class FileUploadServiceApplication {
	public static void main(String[] args) {
		SpringApplication.run(FileUploadServiceApplication.class, args);
	}
}
