package com.miniprojet.projet.repositories;

import com.miniprojet.projet.beans.Category;
import com.miniprojet.projet.beans.Corporate;
import com.miniprojet.projet.beans.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepos extends JpaRepository<Product, Long> {

    // Prototypes of the new functions to add ; like findByName ...
    Product findByName(String name);
    List<Product> findAllByCorporate(Corporate corporate);
    List<Product> findAllByCategory(Category category);
    List<Product> findAllByCategoryId(Long id);

}
