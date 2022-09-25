package com.miniprojet.projet.controllers;

import com.miniprojet.projet.beans.Component;
import com.miniprojet.projet.services.ComponentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/components")
public class ComponentController {

    @Autowired
    ComponentService componentService;

    @GetMapping("")
    List<Component> showAllComponents(){return componentService.findAll();}

    @GetMapping("/product/{id}")
    List<Component> showAllComponentsProduct(@PathVariable Long id){
        return componentService.findAllByProductId(id);
    }

    @GetMapping("/rawMaterial/{id}")
    List<Component> showAllComponentsRawMaterial(@PathVariable Long id){
        return componentService.findAllByRawMaterialId(id);
    }

    @GetMapping("/origin/{id}")
    List<Component> showAllComponentsOrigin(@PathVariable Long id){
        return componentService.findAllByOriginId(id);
    }

    @GetMapping("/find/{id}")
    Component showComponent(@PathVariable Long id){
        return componentService.findById(id);
    }

    @PostMapping("/insert/product")
    List<Component> addComponents(@RequestBody List<Component> components){
        return componentService.addAll(components);
    }

    @PostMapping("/insert")
    Component addComponent(@RequestBody Component component){
        return componentService.add(component);
    }

    @PutMapping("/update")
    Component updateComponent(@RequestBody Component component){
        return componentService.update(component);
    }

    @DeleteMapping("/delete/{id}")
    void deleteComponent(@PathVariable Long id){
        componentService.deleteById(id);
    }

}
