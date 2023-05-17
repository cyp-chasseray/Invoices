package com.example.billeditor.service;

import com.example.billeditor.entity.Client;
import com.example.billeditor.repository.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClientService {
    private final ClientRepository clientRepository;

    @Autowired
    public ClientService(ClientRepository clientRepository) {
        this.clientRepository = clientRepository;
    }


    public List<Client> fetchAllByUserId(long id) {
        return clientRepository.findAllByUserId(id);
    }

    public void createClient(Client client) {clientRepository.save(client);}

    public Client fetchById(long id) {return clientRepository.getClientById(id);}
}

