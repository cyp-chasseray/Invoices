package com.example.billeditor.controller;
import com.example.billeditor.entity.Product;
import com.example.billeditor.entity.User;
import com.example.billeditor.service.ProductService;
import com.example.billeditor.service.UserService;
import jakarta.servlet.http.HttpSession;
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

    @Autowired
    UserService userService;

    @GetMapping("/products")
    public String products(HttpSession session, Model model) {

        String email = (String) session.getAttribute("email");
        User user = userService.findByEmail(email)
                .orElseThrow(() -> new IllegalStateException("User not found"));

        List<Product> products = productService.fetchAllProductsById(user.getId());
        model.addAttribute("products", products);
        return "products";
    }

    @PostMapping("/new-product")
    public String addProduct(@ModelAttribute("product") Product newProduct,
                             HttpSession session) {

        String email = (String) session.getAttribute("email");
        User user = userService.findByEmail(email)
                .orElseThrow(() -> new IllegalStateException("User not found"));

        newProduct.setUser(user);
        productService.createProduct(newProduct);
        return "redirect:/products";
    }
}