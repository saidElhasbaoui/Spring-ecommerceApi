package com.miniprojet.projet.repositories;

import com.miniprojet.projet.beans.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoryRepos extends JpaRepository<Category,Long> {

    // Prototypes of the new functions to add ; like findByName ...

    Category findByName(String name);

}
