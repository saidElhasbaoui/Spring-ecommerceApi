package com.miniprojet.projet.controllers;

import com.miniprojet.projet.beans.Command;
import com.miniprojet.projet.services.CommandService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/commands")
public class CommmandController {

    @Autowired
    CommandService commandService;

    @GetMapping("")
    List<Command> showAllCommands(){return commandService.findAll();}

    @GetMapping("/find/{id}")
    Command showCommand(@PathVariable Long id){return commandService.findById(id);}

    @PostMapping("/insert")
    Command saveCommand(@RequestBody Command command){return commandService.add(command);}

    @PutMapping("/update")
    Command updateCommand(@RequestBody Command command){return commandService.update(command);}

    @DeleteMapping("/delete/{id}")
    void deleteCommand(@PathVariable Long id){commandService.deleteById(id);}

}
