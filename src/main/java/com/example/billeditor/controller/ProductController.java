package com.example.billeditor.controller;
import com.example.billeditor.entity.Client;
import com.example.billeditor.entity.Product;
import com.example.billeditor.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class ProductController {
    @Autowired
    ProductService productService;

    @GetMapping("/products")
    public String products(Model model) {
        List<Product> products = productService.fetchAllProducts();
        model.addAttribute("products", products);
        return "products";
    }

    @PostMapping("/new-product")
    public String addProduct(@ModelAttribute("product") Product newProduct) {
        productService.createProduct(newProduct);
        return "redirect:/products";
    }
}