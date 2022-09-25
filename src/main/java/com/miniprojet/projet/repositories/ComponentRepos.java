package com.miniprojet.projet.repositories;

import com.miniprojet.projet.beans.Component;
import com.miniprojet.projet.beans.Origin;
import com.miniprojet.projet.beans.Product;
import com.miniprojet.projet.beans.RawMaterial;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ComponentRepos extends JpaRepository<Component,Long> {

    // Prototypes of the new functions to add ; like findByName ...

    List<Component> findAllByProduct(Product product);
    List<Component> findAllByRawMaterial(RawMaterial rawMaterial);
    List<Component> findAllByOrigin(Origin origin);

}
