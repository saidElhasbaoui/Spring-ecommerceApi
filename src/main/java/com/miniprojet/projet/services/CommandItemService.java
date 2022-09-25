package com.miniprojet.projet.services;

import com.miniprojet.projet.beans.Client;
import com.miniprojet.projet.beans.Command;
import com.miniprojet.projet.beans.CommandItem;
import com.miniprojet.projet.beans.Product;
import com.miniprojet.projet.repositories.CommandItemRepos;
import com.miniprojet.projet.services.interfaces.ICommandItem;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class CommandItemService implements ICommandItem {

    @Autowired
    CommandItemRepos commandItemRepos;

    @Autowired
    CommandService commandService;

    @Autowired
    ProductService productService;

    @Autowired
    ClientService clientService;

    ////Logger logger = LoggerFactory.getLogger(CategoryService.class);

    @Override
    public List<CommandItem> findAll() {
        //logger.info("Consultation of all command items");
        return commandItemRepos.findAll();
    }

    @Override
    public CommandItem findById(Long id) {
        CommandItem commandItem=commandItemRepos.findById(id).stream().findFirst().orElse(null);
        if(commandItem != null){
            //logger.info("Consultation of the element : "+commandItem);
        }
        return commandItem;
    }

    @Override
    public CommandItem add(CommandItem commandItem) {
        commandItemRepos.save(commandItem);
        //logger.info("New element has been saved : "+commandItem);
        return commandItem;
    }

    @Override
    public CommandItem update(CommandItem commandItem) {
        commandItemRepos.save(commandItem);
        //logger.info("Element has been updated : "+commandItem);
        return commandItem;
    }

    @Override
    public void delete(CommandItem commandItem) {
        commandItemRepos.delete(commandItem);
        //logger.info("Element has been removed : "+commandItem);
    }

    @Override
    public void deleteById(Long id) {
        commandItemRepos.deleteById(id);
        //logger.info("CommandItem has been removed with ID = "+id);
    }

    @Override
    public List<CommandItem> addAll(List<CommandItem> commandItems) {
        Command command=commandItems.get(0).getCommand();

        for (CommandItem commandItem:commandItems) {
            if (! commandItem.getCommand().equals(command)) return null;
        }

        Client client=command.getClient();
        if(client.getId() !=null ) {
            client=clientService.findById(command.getClient().getId());
        }
        else{
            client=clientService.add(client);
        }
        command.setClient(client);
        commandService.add(command);

        Double cost=0.0;
        List<CommandItem> commandItemsToAdd=new ArrayList<>();
        for (CommandItem commandItem:commandItems) {
            Product product=commandItem.getProduct();
            if(product.getId() !=null){
                product=productService.findById(commandItem.getProduct().getId());
                commandItem.setProduct(product);
            }

            if(product.getQuantity()-commandItem.getQuantity() >=0){
                commandItem.setCommand(command);
                commandItem.setPrice(commandItem.getQuantity()*product.getPrice());
                cost+=commandItem.getPrice();
                product.setQuantity(
                        commandItem.getProduct().getQuantity()-commandItem.getQuantity()
                );

                productService.update(product);
                commandItemsToAdd.add(commandItem);
            }
            else {
//                logger.info(" Quantity is not enough from the product "+commandItem.getProduct()+
//                        " the required quantity is "+commandItem.getQuantity());
            }
        }

        command.setCost(cost);
        Date date=new Date();
        command.setDate(date.toString());
        commandService.update(command);
        commandItemRepos.saveAll(commandItemsToAdd);
        //logger.info("CommandItems has been saved : "+commandItems);
        return commandItems;
    }

    @Override
    public List<CommandItem> findAllByProduct(Product product) {
        List<CommandItem> commandItems=commandItemRepos.findAllByProduct(product);
        if(commandItems !=null ){
            //logger.info("Consultation of elements : "+commandItems);
        }
        return commandItems;
    }

    @Override
    public List<CommandItem> findAllByCommand(Command command) {
        List<CommandItem> commandItems=commandItemRepos.findAllByCommand(command);
        if(commandItems !=null ){
            //logger.info("Consultation of elements : "+commandItems);
        }
        return commandItems;
    }

    @Override
    public List<CommandItem> findAllByProductId(Long id) {
        Product product=productService.findById(id);
        return this.findAllByProduct(product);
    }

    @Override
    public List<CommandItem> findAllByCommandId(Long id) {
        Command command=commandService.findById(id);
        return this.findAllByCommand(command);
    }
}
