package com.zidio.fileupload.service.impl;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.*;
import java.nio.file.*;
import java.util.UUID;

@Service
public class StorageService {
    private final Path root;

    public StorageService(@Value("${file.upload.dir:uploads}") String dir) {
        this.root = Paths.get(dir).toAbsolutePath().normalize();
        try { Files.createDirectories(this.root); } catch (IOException ignored) {}
    }

    public String save(MultipartFile file) throws IOException {
        String name = UUID.randomUUID().toString() + "_" + file.getOriginalFilename();
        Path target = root.resolve(name).normalize();
        Files.copy(file.getInputStream(), target, StandardCopyOption.REPLACE_EXISTING);
        return target.toString();
    }
}
