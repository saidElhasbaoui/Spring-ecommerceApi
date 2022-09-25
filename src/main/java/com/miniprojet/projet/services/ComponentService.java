package com.miniprojet.projet.services;

import com.miniprojet.projet.beans.Component;
import com.miniprojet.projet.beans.Origin;
import com.miniprojet.projet.beans.Product;
import com.miniprojet.projet.beans.RawMaterial;
import com.miniprojet.projet.repositories.ComponentRepos;
import com.miniprojet.projet.services.interfaces.IComponent;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ComponentService implements IComponent {
    @Autowired
    ComponentRepos componentRepos;

    @Autowired
    OriginService originService;

    @Autowired
    RawMaterialService rawMaterialService;

    @Autowired
    ProductService productService;

    //Logger logger = LoggerFactory.getLogger(CategoryService.class);

    @Override
    public List<Component> findAll() {
        return componentRepos.findAll();
    }

    @Override
    public Component findById(Long id) {
        return componentRepos.findById(id).stream().findFirst().orElse(null);
    }

    @Override
    public Component add(Component component) {

        Origin origin=component.getOrigin();
        RawMaterial rawMaterial = component.getRawMaterial();
        Product product = component.getProduct();

        if(origin.getId()!=null){
            origin=originService.findById(origin.getId());
        }
        else{
            origin=originService.add(origin);
        }
        component.setOrigin(origin);

        if(rawMaterial.getId()!=null){
            rawMaterial=rawMaterialService.findById(rawMaterial.getId());
        }
        else{
            rawMaterial=rawMaterialService.add(rawMaterial);
        }
        component.setRawMaterial(rawMaterial);

        if(product.getId()!=null){
            product=productService.findById(product.getId());
        }
        else{
            product=productService.add(product);
        }
        component.setProduct(product);

        componentRepos.save(component);
        return component;
    }

    @Override
    public Component update(Component component) {
        componentRepos.save(component);
        return component;
    }

    @Override
    public void delete(Component component) {
        componentRepos.delete(component);
    }

    @Override
    public void deleteById(Long id) {
        componentRepos.deleteById(id);
    }

    @Override
    public List<Component> addAll(List<Component> components) {
        Product product=components.get(0).getProduct();

        for (Component component:components) {
            if(! component.getProduct().equals(product)) return null;
        }

        if(product.getId()!=null){
            product=productService.findById(product.getId());
        }
        else{
            product=productService.add(product);
        }

        for (Component component:components) {
            component.setProduct(product) ;
            Origin origin=component.getOrigin();
            if(origin.getId()!=null){
                origin=originService.findById(origin.getId());
            }
            else{
                origin=originService.add(origin);
            }
            component.setOrigin(origin);

            RawMaterial rawMaterial = component.getRawMaterial();
            if(rawMaterial.getId()!=null){
                rawMaterial=rawMaterialService.findById(rawMaterial.getId());
            }
            else{
                rawMaterial=rawMaterialService.add(rawMaterial);
            }
            component.setRawMaterial(rawMaterial);

            componentRepos.save(component);
        }

        return components;
    }

    @Override
    public List<Component> findAllByProduct(Product product) {
        return componentRepos.findAllByProduct(product);
    }

    @Override
    public List<Component> findAllByRawMaterial(RawMaterial rawMaterial) {
        return componentRepos.findAllByRawMaterial(rawMaterial);
    }

    @Override
    public List<Component> findAllByOrigin(Origin origin) {
        return componentRepos.findAllByOrigin(origin);
    }

    @Override
    public List<Component> findAllByProductId(Long id) {
        Product product=productService.findById(id);
        return this.findAllByProduct(product);
    }

    @Override
    public List<Component> findAllByRawMaterialId(Long id) {
        RawMaterial rawMaterial=rawMaterialService.findById(id);
        return this.findAllByRawMaterial(rawMaterial);
    }

    @Override
    public List<Component> findAllByOriginId(Long id) {
        Origin origin=originService.findById(id);
        return this.findAllByOrigin(origin);
    }
}
