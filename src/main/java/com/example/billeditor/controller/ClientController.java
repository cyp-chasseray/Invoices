package com.example.billeditor.controller;

import com.example.billeditor.entity.Client;
import com.example.billeditor.entity.User;
import com.example.billeditor.service.ClientService;
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
public class ClientController {
    @Autowired
    ClientService clientService;

    @Autowired
    UserService userService;

    @GetMapping("/clients")
    public String clients(HttpSession session,
                          Model model) {

        String email = (String) session.getAttribute("email");
        User user = userService.findByEmail(email)
                .orElseThrow(() -> new IllegalStateException("User not found"));

        List<Client> clients = clientService.fetchAllByUserId(user.getId());
        model.addAttribute("clients", clients);
        return "clients";
    }

    @PostMapping("/new-client")
    public String addClient(@ModelAttribute("client") Client newClient,
                            HttpSession session) {

        String email = (String) session.getAttribute("email");
        User user = userService.findByEmail(email)
                .orElseThrow(() -> new IllegalStateException("User not found"));

        newClient.setUser(user);
        clientService.createClient(newClient);
        return "redirect:/clients";
    }
}

