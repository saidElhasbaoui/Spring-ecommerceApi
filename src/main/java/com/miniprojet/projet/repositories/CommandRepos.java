package com.miniprojet.projet.repositories;

import com.miniprojet.projet.beans.Client;
import com.miniprojet.projet.beans.Command;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CommandRepos extends JpaRepository<Command,Long> {

    // Prototypes of the new functions to add ; like findByName ...
    List<Command> findAllByClient(Client client);
}
