package com.example.onlinemarketplace.controllers;



import com.example.onlinemarketplace.models.Product;
import com.example.onlinemarketplace.service.ProductService;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/")
@RequiredArgsConstructor
public class ProductController {

    private final ProductService productService;
    @GetMapping()
    public String products(Model model){
        model.addAttribute("products",  productService.getAllProducts());
        return "index";
    }

    @GetMapping("/product/{id}")
    public String productInfo(@PathVariable Long id, Model model){
        model.addAttribute("product",productService.findOne(id));
        return "product-info";
    }

    @PostMapping
    public String addProduct(Product product){
        productService.saveProduct(product);
       return  "redirect:/";
    }

    @DeleteMapping("/product/delete/{id}")
    public String deleteProduct(@PathVariable Long id){
        return "redirect:/";
    }


}
