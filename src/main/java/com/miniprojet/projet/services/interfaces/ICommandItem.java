package com.miniprojet.projet.services.interfaces;

import com.miniprojet.projet.beans.*;

import java.util.List;

public interface ICommandItem {

    List<CommandItem> findAll();
    CommandItem findById(Long id);
    CommandItem add(CommandItem commandItem);
    CommandItem update(CommandItem commandItem);
    void delete(CommandItem commandItem);
    void deleteById(Long id);
    List<CommandItem> addAll(List<CommandItem> commandItems);

    List<CommandItem> findAllByProduct(Product product);
    List<CommandItem> findAllByCommand(Command command);

    List<CommandItem> findAllByProductId(Long id);
    List<CommandItem> findAllByCommandId(Long id);

}
