package com.miniprojet.projet.repositories;

import com.miniprojet.projet.beans.Corporate;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CorporateRepos extends JpaRepository<Corporate,Long> {

    // Prototypes of the new functions to add ; like findByName ...

    Corporate findByName(String name);

}
