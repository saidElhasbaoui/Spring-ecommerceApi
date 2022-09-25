package com.miniprojet.projet.controllers;

import com.miniprojet.projet.beans.Origin;
import com.miniprojet.projet.services.OriginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/origins")
public class OriginController {

    @Autowired
    OriginService originService;

    @GetMapping("")
    List<Origin> showAllOrigins(){
       return originService.findAll();
    }

    @GetMapping("/find/{id}")
    Origin showOrigin(@PathVariable Long id){
        return originService.findById(id);
    }

    @PostMapping("/insert")
    Origin addOrigin(@RequestBody Origin origin){
        return originService.add(origin);
    }

    @PutMapping("/update")
    Origin updateOrigin(@RequestBody Origin origin){
        return originService.update(origin);
    }

    @DeleteMapping("/delete/{id}/{deleting}")
    void deleteOrigin(@PathVariable Long id , @PathVariable int deleting){
        originService.deleteById(id,deleting);
    }
}
