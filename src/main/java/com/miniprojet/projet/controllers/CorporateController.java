package com.miniprojet.projet.controllers;

import com.miniprojet.projet.beans.Corporate;
import com.miniprojet.projet.services.CorporateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/corporates")
public class CorporateController {

    @Autowired
    CorporateService corporateService;

    @GetMapping("")
    List<Corporate> showAllCorporates(){
        return corporateService.findAll();
    }

    @GetMapping("/find/{id}")
    Corporate showCorporate(@PathVariable Long id){
        return corporateService.findById(id);
    }

    @PostMapping("/insert")
    Corporate addCorporate(@RequestBody Corporate corporate){
        return corporateService.add(corporate);
    }

    @PutMapping("/update")
    Corporate updateCorporate(@RequestBody Corporate corporate){return corporateService.update(corporate);}

    @DeleteMapping("/delete/{id}")
    void deleteCorporate(@PathVariable Long id){
        corporateService.deleteById(id);
    }
}
