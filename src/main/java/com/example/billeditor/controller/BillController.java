package com.example.billeditor.controller;

import com.example.billeditor.entity.Bill;
import com.example.billeditor.entity.Client;
import com.example.billeditor.entity.Product;
import com.example.billeditor.entity.User;
import com.example.billeditor.service.BillService;
import com.example.billeditor.service.ClientService;
import com.example.billeditor.service.ProductService;
import com.example.billeditor.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.List;

@Controller
public class BillController {
    @Autowired
    BillService billService;

    @Autowired
    ClientService clientService;

    @Autowired
    ProductService productService;

    @GetMapping("/bills")
    public String newBill(Model model) {
        List<Client> clients = clientService.fetchAllClients();
        List<Product> products = productService.fetchAllProducts();
        List<Bill> bills = billService.fetchAllBills();
        model.addAttribute("bills", bills);
        model.addAttribute("clients", clients);
        model.addAttribute("products", products);
        model.addAttribute("bill", new Bill());
        return "bills";
    }

    @PostMapping("/new-bill")
    public String addBill(@ModelAttribute("bill") Bill newBill, @RequestParam("clientId") Long clientId, @RequestParam("productIds") List<Long> productIds) {
        newBill.setDate(LocalDateTime.now());
        newBill.setPaymentLimitDate(newBill.getDate().plus(1, ChronoUnit.MONTHS));
        Client client = clientService.fetchById(clientId);
        newBill.setClient(client);
        List<Product> products = productService.fetchAllProductsByIdList(productIds);
        newBill.setProducts(products);
        billService.createBill(newBill);
        return "redirect:/bills";
    }
}