package com.library.persistency.repository;

import com.library.persistency.entity.Client;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;
import java.util.List;

@Repository
public class ClientRepositoryImpl implements ClientRepository {

    @PersistenceContext
    private EntityManager entityManager;

    public List<Client> findAll() {
        Query query = entityManager.createQuery("SELECT C FROM Client C ");

        return query.getResultList();
    }

    public Client findById(Long idClient) {
        Query query = entityManager.createQuery("FROM Client WHERE idClient = :idClient");
        query.setParameter("idClient", idClient);

        return (Client) query.getSingleResult();
    }

    @Transactional
    @Override
    public long save(Client client) {
        System.out.println("Repository: Saving client: " + client);
        return entityManager.merge(client).getId();
    }

    public List<Client> findByDocument(String document) {
        List clientList;
        if (!document.equals("*")) {
            Query query = entityManager.createQuery("SELECT c FROM Client c WHERE cpf = :cpf ");
            query.setParameter("cpf", document);
            clientList = query.getResultList();
        } else {
            clientList = findAll();
        }

        return clientList;
    }

    public List<Client> findByName(String name) {
        List clientList;
        if (!name.equals("*")) {
            Query query = entityManager.createQuery("SELECT c FROM Client c WHERE name like :name ");
            query.setParameter("name", "%" + name + "%");
            clientList = query.getResultList();
        } else {
            clientList = findAll();
        }

        return clientList;
    }
}
