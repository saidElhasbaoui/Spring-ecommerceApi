package com.miniprojet.projet.services.interfaces;

import com.miniprojet.projet.beans.*;

import java.util.List;

public interface IComponent {

    List<Component> findAll();
    Component findById(Long id);
    Component add(Component component);
    Component update(Component component);
    void delete(Component component);
    void deleteById(Long id);
    List<Component> addAll(List<Component> components);

    List<Component> findAllByProduct(Product product);
    List<Component> findAllByRawMaterial(RawMaterial rawMaterial);
    List<Component> findAllByOrigin(Origin origin);

    List<Component> findAllByProductId(Long id);
    List<Component> findAllByRawMaterialId(Long id);
    List<Component> findAllByOriginId(Long id);

}
