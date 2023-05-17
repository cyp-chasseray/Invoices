package com.example.billeditor.controller;

import com.example.billeditor.entity.Client;
import com.example.billeditor.entity.Product;
import com.example.billeditor.service.ClientService;
import com.example.billeditor.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;
import java.util.Optional;

@Controller
public class ClientController {
    @Autowired
    ClientService clientService;

    @GetMapping("/clients")
    public String clients(Model model) {
        List<Client> clients = clientService.fetchAllClients();
        model.addAttribute("clients", clients);
        return "clients";
    }

    @PostMapping("/new-client")
    public String addClient(@ModelAttribute("client") Client newClient) {
        clientService.createClient(newClient);
        return "redirect:/clients";
    }
}

