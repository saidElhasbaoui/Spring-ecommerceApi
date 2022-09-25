package com.miniprojet.projet.services.interfaces;

import com.miniprojet.projet.beans.Category;
import com.miniprojet.projet.beans.Corporate;
import com.miniprojet.projet.beans.Product;

import java.util.List;

public interface IProduct {

    List<Product> findAll();
    Product findById(Long id);
    Product findByName(String name);
    Product add(Product product);
    Product update(Product product);
    void delete(Product product);
    void deleteById(Long id);
    List<Product> findAllByCorporate(Corporate corporate);
    List<Product> findAllByCategory(Category category);
    List<Product> findAllByCorporateId(Long id);
    List<Product> findAllByCategoryId(Long id);

}
