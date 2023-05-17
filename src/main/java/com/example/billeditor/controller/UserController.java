package com.example.billeditor.controller;

import com.example.billeditor.entity.User;
import com.example.billeditor.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class UserController {
    @Autowired
    UserService userService;

    @GetMapping("/profile")
    public String home(Model model) {
        User user = userService.findByEmail("admin@my-invoice.fr")
                .orElseThrow(() -> new IllegalStateException("User not found"));
        model.addAttribute("user", user);
        return "profile";
    }
}