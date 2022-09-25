package com.miniprojet.projet.services;

import com.miniprojet.projet.beans.Client;
import com.miniprojet.projet.repositories.ClientRepos;
import com.miniprojet.projet.services.interfaces.IClient;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClientService implements IClient {

    @Autowired
    ClientRepos clientRepos;

    //Logger logger = LoggerFactory.getLogger(CategoryService.class);

    @Override
    public List<Client> findAll() {
        //logger.info("Consultation of all clients");
        return clientRepos.findAll();
    }

    @Override
    public Client findById(Long id) {
        Client client=clientRepos.findById(id).stream().findFirst().orElse(null);
        if(client!=null){
            //logger.info("Consultation of the element : "+client);
        }
        return client;
    }

    @Override
    public Client add(Client client) {
        if(client !=null){
            Client c=clientRepos.findByCin(client.getCin());
            if(c==null) {
                clientRepos.save(client);
                //logger.info("New element has been saved : "+client);
                return client;
            }
            else{
                //logger.info("Failed to add : "+client+" the CIN of this element is already exist");
                return c;
            }
        }
        else
            return null;

    }

    @Override
    public Client update(Client client) {
        Client cl=this.findById(client.getId());
        if(cl != null) {
            clientRepos.save(client);
            //logger.info("Element has been updated : "+client);
            return client;
        }
        else{
            return null;
        }

    }

    @Override
    public void delete(Client client) {
        clientRepos.delete(client);
        //logger.info("Element has been removed : "+client);
    }

    @Override
    public void deleteById(Long id) {
        clientRepos.deleteById(id);
        //logger.info("Client has been removed with ID = "+id);
    }

}
