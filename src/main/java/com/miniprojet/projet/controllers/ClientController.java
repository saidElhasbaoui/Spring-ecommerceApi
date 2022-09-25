package com.miniprojet.projet.controllers;

import com.miniprojet.projet.beans.Client;
import com.miniprojet.projet.services.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/clients")
public class ClientController {

    @Autowired
    ClientService clientService;

    @GetMapping("")
    List<Client> showAllClients(){
        return clientService.findAll();
    }

    @GetMapping("/find/{id}")
    Client showClient(@PathVariable Long id){ return clientService.findById(id); }

    @PostMapping("/insert")
    Client saveClient(@RequestBody Client client){
        return clientService.add(client);
    }

    @PutMapping("/update")
    Client updateClient(@RequestBody Client client){
        return clientService.update(client);
    }

    @DeleteMapping("/delete/{id}")
    void deleteClient(@PathVariable Long id){
        clientService.deleteById(id);
    }
}
