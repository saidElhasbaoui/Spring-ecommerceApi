package com.miniprojet.projet.repositories;

import com.miniprojet.projet.beans.RawMaterial;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RawMaterialRepos extends JpaRepository<RawMaterial,Long> {

    // Prototypes of the new functions to add ; like findByName ...

    RawMaterial findByName(String name);
}
