package com.miniprojet.projet.repositories;

import com.miniprojet.projet.beans.Client;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ClientRepos extends JpaRepository<Client,Long> {

    // Prototypes of the new functions to add ; like findByName ...

    Client findByCin(String cin);

}
