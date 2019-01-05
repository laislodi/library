package com.library.persistency.repository;

import com.library.persistency.entity.Client;

import java.util.List;

public interface ClientRepository {

    List<Client> findAll();

    Client findById(Long idClient);

    long save(Client client);

    List<Client> findByDocument(String document);

    List<Client> findByName(String name);
}
