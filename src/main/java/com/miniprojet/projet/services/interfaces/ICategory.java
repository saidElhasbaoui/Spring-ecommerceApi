package com.miniprojet.projet.services.interfaces;

import com.miniprojet.projet.beans.Category;

import java.util.List;

public interface ICategory {

    List<Category> findAll();
    Category findById(Long id);
    Category findByName(String name);
    Category add(Category category);
    Category update(Category category);
    void delete(Category category);
    void deleteById(Long id);

}
