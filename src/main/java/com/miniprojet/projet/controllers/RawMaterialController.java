package com.miniprojet.projet.controllers;

import com.miniprojet.projet.beans.RawMaterial;
import com.miniprojet.projet.services.RawMaterialService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/rawMaterials")
public class RawMaterialController {

    @Autowired
    RawMaterialService rawMaterialService;

    @GetMapping("")
    List<RawMaterial> showAllRawMaterials(){
        return rawMaterialService.findAll();
    }

    @GetMapping("/find/{id}")
    RawMaterial showRawMaterial(@PathVariable Long id){
        return rawMaterialService.findById(id);
    }

    @PostMapping("/insert")
    RawMaterial addRawMaterial(@RequestBody RawMaterial rawMaterial){
        return rawMaterialService.add(rawMaterial);
    }

    @PutMapping("/update")
    RawMaterial updateRawMaterial(@RequestBody RawMaterial rawMaterial){
        return rawMaterialService.update(rawMaterial);
    }

    @DeleteMapping("/delete/{id}")
    void deleteRawMaterial(@PathVariable Long id){
        rawMaterialService.deleteById(id);
    }

}
