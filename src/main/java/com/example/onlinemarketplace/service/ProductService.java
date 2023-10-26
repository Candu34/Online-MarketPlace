package com.example.onlinemarketplace.service;


import com.example.onlinemarketplace.models.Image;
import com.example.onlinemarketplace.models.Product;
import com.example.onlinemarketplace.repository.ProductRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Service
@AllArgsConstructor
@Slf4j
public class ProductService {

    @Autowired
    private final ProductRepository productRepository;

    public List<Product> listProducts(String title) {

        if (title != null)
            return productRepository.findByTitle(title);
        return productRepository.findAll();
    }


    public Product findOne(long id) {
        return productRepository.findById(id).orElse(null);
    }

    public void saveProduct(Product product, List<MultipartFile> files) throws IOException{
        List<Image> images = new ArrayList<>();

        for (MultipartFile file : files) {
            if (file.getSize() != 0) {
                Image image = toImageEntity(file);
                image.setProduct(product);
                images.add(image);
            }
        }
        if(!images.isEmpty()) {
            images.get(0).setPreviewImage(true);
        }
        product.setImages(images);


        log.info("Saving new Product. Title: {}; Author: {};",
                product.getTitle(),
                product.getNameOfTheSeller());

        Product productFromDb = productRepository.save(product);
        productFromDb.setPreviewImageId(productFromDb.getImages().get(0).getId());
        productRepository.save(product);
    }

    private Image toImageEntity(MultipartFile file) throws IOException {
        Image image = new Image();
        image.setName(file.getName());
        image.setOriginalFileName(file.getOriginalFilename());
        image.setContentType(file.getContentType());
        image.setSize(file.getSize());
        image.setBytes(file.getBytes());
        return image;
    }

    public void deleteProductById(long id) {
        productRepository.deleteById(id);
    }


}
