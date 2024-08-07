package org.example.service;

import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@Component
public interface CarBrandImageService {
    String addImage(MultipartFile file) throws IOException;
}
