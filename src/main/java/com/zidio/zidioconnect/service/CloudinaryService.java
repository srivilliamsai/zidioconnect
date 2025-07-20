package com.zidio.zidioconnect.service;

import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Map;

@Service
public class CloudinaryService {

    @Autowired
    private Cloudinary cloudinary;

    public String uploadFile(MultipartFile file) {
        try {
            @SuppressWarnings("unchecked") //  Suppress unchecked cast warning
            Map<String, Object> uploadResult = (Map<String, Object>) cloudinary.uploader().upload(
                file.getBytes(), ObjectUtils.emptyMap());

            return uploadResult.get("secure_url").toString(); //  Cloudinary secure URL
        } catch (IOException e) {
            throw new RuntimeException("File upload to Cloudinary failed", e);
        }
    }
}
