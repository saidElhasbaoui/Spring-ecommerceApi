package com.miniprojet.projet.services.interfaces;
import com.miniprojet.projet.beans.Client;
import com.miniprojet.projet.beans.Command;

import java.util.List;

public interface ICommand {

    List<Command> findAll();
    Command findById(Long id);
    Command add(Command command);
    Command update(Command command);
    void delete(Command command);
    void deleteById(Long id);
    List<Command> findAllByClient(Client client);
    List<Command> findAllByClientId(Long id);


}
