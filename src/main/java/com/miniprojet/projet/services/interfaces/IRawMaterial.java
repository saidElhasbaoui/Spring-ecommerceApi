package com.miniprojet.projet.services.interfaces;

import com.miniprojet.projet.beans.RawMaterial;

import java.util.List;

public interface IRawMaterial {

    List<RawMaterial> findAll();
    RawMaterial findById(Long id);
    RawMaterial findByName(String name);
    RawMaterial add(RawMaterial rawMaterial);
    RawMaterial update(RawMaterial rawMaterial);
    void delete(RawMaterial rawMaterial);
    void deleteById(Long id);
}
