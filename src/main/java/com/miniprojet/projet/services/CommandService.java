package com.miniprojet.projet.services;

import com.miniprojet.projet.beans.Client;
import com.miniprojet.projet.beans.Command;
import com.miniprojet.projet.repositories.CommandRepos;
import com.miniprojet.projet.services.interfaces.ICommand;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CommandService implements ICommand {

    @Autowired
    CommandRepos commandRepos;

    @Autowired
    ClientService clientService;

    //Logger logger = LoggerFactory.getLogger(CategoryService.class);

    @Override
    public List<Command> findAll() {
        return commandRepos.findAll();
    }

    @Override
    public Command findById(Long id) {
        return commandRepos.findById(id).stream().findFirst().orElse(null);
    }

    @Override
    public Command add(Command command) {
        Client client=command.getClient();
        if(command.getClient().getId()!=null){
            client=clientService.findById(client.getId());
        }
        else{
            client=clientService.add(client);
        }
        command.setClient(client);
        commandRepos.save(command);
        //logger.info("New element has been saved : "+command);
        return command;
    }

    @Override
    public Command update(Command command) {
        commandRepos.save(command);
        return command;
    }

    @Override
    public void delete(Command command) {
        try {
            commandRepos.delete(command);
        }
        catch (Exception e){
            System.out.println(e.getMessage());
        }

    }

    @Override
    public void deleteById(Long id) {
        commandRepos.deleteById(id);
    }

    @Override
    public List<Command> findAllByClient(Client client) {
        return commandRepos.findAllByClient(client);
    }

    @Override
    public List<Command> findAllByClientId(Long id) {
        Client client=clientService.findById(id);
        return this.findAllByClient(client);
    }


}
