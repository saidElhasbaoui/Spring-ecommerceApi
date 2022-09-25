package com.miniprojet.projet.repositories;

import com.miniprojet.projet.beans.Command;
import com.miniprojet.projet.beans.CommandItem;
import com.miniprojet.projet.beans.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CommandItemRepos extends JpaRepository<CommandItem,Long> {

    // Prototypes of the new functions to add ; like findByName ...

    List<CommandItem> findAllByCommand(Command command);
    List<CommandItem> findAllByProduct(Product product);
}
