package com.example.onlinemarketplace.service;

import com.example.onlinemarketplace.models.Image;
import com.example.onlinemarketplace.repository.ImageRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ImageService {
    private final ImageRepository imageRepository;

    public Image findById(Long id){
        return imageRepository.findById(id).orElse(null);
    }
}
