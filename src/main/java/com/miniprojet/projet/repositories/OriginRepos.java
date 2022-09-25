package com.miniprojet.projet.repositories;

import com.miniprojet.projet.beans.Origin;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OriginRepos extends JpaRepository<Origin ,Long> {

    // Prototypes of the new functions to add ; like findByName ...

    Origin findByName(String name);

}
