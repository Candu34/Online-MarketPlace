package com.example.onlinemarketplace.controllers;


import com.example.onlinemarketplace.models.Product;
import com.example.onlinemarketplace.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@Controller
@RequestMapping("/")
@RequiredArgsConstructor
public class ProductController {

    private final ProductService productService;

    @GetMapping()
    public String products(@RequestParam(name = "title", required = false) String title, Model model) {
        model.addAttribute("products", productService.listProducts(title));
        return "products";
    }

    @GetMapping("/product/{id}")
    public String productInfo(@PathVariable Long id, Model model) {
        Product product =  productService.findOne(id);
        model.addAttribute("product",product);
        model.addAttribute("images",product.getImages());
        return "product-info";
    }

    @PostMapping("product/create")
    public String addProduct(@RequestParam("files") List<MultipartFile> files, Product product) throws IOException {

        productService.saveProduct(product, files);
        return "redirect:/";
    }

    @PostMapping("/product/delete/{id}")
    public String deleteProduct(@PathVariable Long id) {
        productService.deleteProductById(id);
        return "redirect:/";
    }


}
