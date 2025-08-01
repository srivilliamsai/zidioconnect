package com.zidio.zidioconnect.security;

import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class CloudinaryConfig {

    @Bean
    public Cloudinary cloudinary() {
        return new Cloudinary(ObjectUtils.asMap(
            "cloud_name", "your_cloud_name",     //  Replace with real values
            "api_key", "your_api_key",
            "api_secret", "your_api_secret",
            "secure", true
        ));
    }
}
