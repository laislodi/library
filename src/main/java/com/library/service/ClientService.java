package com.library.service;

import org.springframework.beans.factory.annotation.Autowired;
import com.library.persistency.entity.Client;
import com.library.persistency.repository.ClientRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClientService {

    @Autowired
    ClientRepository clientRepository;

    public List<Client> findAll() {
        return clientRepository.findAll();
    }

    public Client findById(Long idClient) {
        return clientRepository.findById(idClient);
    }

    public long save(Client client) {
        System.out.println("Service: Saving client: " + client);
        return clientRepository.save(client);
    }

    public List<Client> findByDocument(String document) {
        return clientRepository.findByDocument(document);
    }

    public List<Client> findByName(String name) {
        return clientRepository.findByName(name);
    }
}
