package com.zidio.fileupload.controller;

import com.zidio.fileupload.service.impl.StorageService;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@RestController @RequestMapping("api/files")
public class FileController {
    private final StorageService storage;
    public FileController(StorageService storage){ this.storage = storage; }

    @PostMapping("/upload")
    @PreAuthorize("hasAuthority('ROLE_RECRUITER') or hasAuthority('ROLE_STUDENT')")
    public ResponseEntity<String> upload(@RequestParam("file") MultipartFile file) throws Exception {
        String path = storage.save(file);
        return ResponseEntity.ok(path);
    }
}