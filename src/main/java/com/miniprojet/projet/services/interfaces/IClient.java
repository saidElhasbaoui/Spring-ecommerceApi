package com.miniprojet.projet.services.interfaces;

import com.miniprojet.projet.beans.Category;
import com.miniprojet.projet.beans.Client;

import java.util.List;

public interface IClient {

    List<Client> findAll();
    Client findById(Long id);
    Client add(Client client);
    Client update(Client client);
    void delete(Client client);
    void deleteById(Long id);
}
