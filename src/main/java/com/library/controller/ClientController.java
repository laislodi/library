package com.library.controller;

import com.library.persistency.entity.Client;
import com.library.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/client")
public class ClientController {

    @Autowired
    ClientService clientService;

    @GetMapping(value = "/find")
    public List<Client> findAll() {
        return clientService.findAll();
    }

    @GetMapping(value = "/find-id")
    public Client findById(@RequestParam(value = "id") long idClient) {
        return clientService.findById(idClient);
    }

    @GetMapping(value = "/find-document/{document}")
    public List<Client> findByDocument(@PathVariable(value = "document") String cpf) {
        return clientService.findByDocument(cpf);
    }

    @GetMapping(value = "/find-name/{name}")
    public List<Client> findByName(@PathVariable(value = "name") String name) {
        return clientService.findByName(name);
    }

    @PostMapping(value = "/new")
    public long newClient(@RequestBody Client client) {
        System.out.println("Controller: Saving client: " + client);
        return clientService.save(client);
    }



}
