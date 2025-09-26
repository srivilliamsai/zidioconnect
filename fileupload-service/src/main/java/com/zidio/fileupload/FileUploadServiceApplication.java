package com.zidio.fileupload;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = {"com.zidio.fileupload"})
public class FileUploadServiceApplication {
    public static void main(String[] args) { SpringApplication.run(FileUploadServiceApplication.class, args); }
}
