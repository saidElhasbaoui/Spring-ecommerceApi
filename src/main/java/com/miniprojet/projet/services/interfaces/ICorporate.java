package com.miniprojet.projet.services.interfaces;

import com.miniprojet.projet.beans.Corporate;

import java.util.List;

public interface ICorporate {

    List<Corporate> findAll();
    Corporate findById(Long id);
    Corporate findByName(String name);
    Corporate add(Corporate corporate);
    Corporate update(Corporate corporate);
    void delete(Corporate corporate);
    void deleteById(Long id);

}
