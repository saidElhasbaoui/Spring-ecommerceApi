package com.miniprojet.projet.services.interfaces;

import com.miniprojet.projet.beans.Category;
import com.miniprojet.projet.beans.Origin;

import java.util.List;

public interface IOrigin {

    List<Origin> findAll();
    Origin findById(Long id);
    Origin findByName(String name);
    Origin add(Origin origin);
    Origin update(Origin origin);
    void delete(Origin origin);
    void deleteById(Long id , int level);
}
