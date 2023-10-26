package com.example.onlinemarketplace.repository;

import com.example.onlinemarketplace.models.Image;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;

@Transactional
public interface ImageRepository extends JpaRepository<Image, Long> {


}
