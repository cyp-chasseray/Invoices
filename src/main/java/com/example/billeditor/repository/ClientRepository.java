package com.example.billeditor.repository;

import com.example.billeditor.entity.Client;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ClientRepository extends JpaRepository<Client, Long> {
    Client getClientById(long id);
    List<Client> findAllByUserId(long user_id);

}
