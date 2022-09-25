package com.miniprojet.projet.controllers;

import com.miniprojet.projet.beans.CommandItem;
import com.miniprojet.projet.services.CommandItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/commandItems")
public class CommmandItemController {

    @Autowired
    CommandItemService commandItemService;

    @GetMapping("")
    List<CommandItem> showAllCommandItems(){return commandItemService.findAll();}

    @GetMapping("/product/{id}")
    List<CommandItem> showAllCommandItemsProduct(@PathVariable Long id){
        return commandItemService.findAllByProductId(id);
    }

    @GetMapping("/command/{id}")
    List<CommandItem> showAllCommandItemsCommand(@PathVariable Long id){
        return commandItemService.findAllByCommandId(id);
    }

    @GetMapping("/find/{id}")
    CommandItem showCommandItem(@PathVariable Long id){
        return commandItemService.findById(id);
    }

    @PostMapping("/insert/command")
    List<CommandItem> addCommandItems(@RequestBody CommandItem... commandItems){
        List<CommandItem> commandItemsList= List.of(commandItems);
        return commandItemService.addAll(commandItemsList);
    }

    @PostMapping("/insert")
    CommandItem addCommandItem(@RequestBody CommandItem commandItem){
        return commandItemService.add(commandItem);
    }

    @PutMapping("/update")
    CommandItem updateCommandItem(@RequestBody CommandItem commandItem){
        return commandItemService.update(commandItem);
    }

    @DeleteMapping("/delete/{id}")
    void deleteCommandItem(@PathVariable Long id){
        commandItemService.deleteById(id);
    }

}
