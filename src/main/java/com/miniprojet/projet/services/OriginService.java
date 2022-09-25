package com.miniprojet.projet.services;

import com.miniprojet.projet.beans.Component;
import com.miniprojet.projet.beans.Origin;
import com.miniprojet.projet.repositories.ComponentRepos;
import com.miniprojet.projet.repositories.OriginRepos;
import com.miniprojet.projet.services.interfaces.IOrigin;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OriginService implements IOrigin {

    @Autowired
    OriginRepos originRepos;

    @Autowired
    ComponentRepos componentRepos;

    //Logger logger = LoggerFactory.getLogger(CategoryService.class);

    @Override
    public List<Origin> findAll() {
        return originRepos.findAll();
    }

    @Override
    public Origin findById(Long id) {
        return originRepos.findById(id).stream().findFirst().orElse(null) ;
    }

    @Override
    public Origin findByName(String name) {
        return originRepos.findByName(name);
    }

    @Override
    public Origin add(Origin origin) {
        if(origin !=null){
            Origin orig=originRepos.findByName(origin.getName());
            if(orig==null){
                originRepos.save(origin);
                return origin;
            }
            else{
                return orig;
            }
        }
        else
            return null;

    }

    @Override
    public Origin update(Origin origin) {
        originRepos.save(origin);
        return origin;
    }

    @Override
    public void delete(Origin origin) {
        originRepos.delete(origin);
    }

    @Override
    public void deleteById(Long id , int level) {
        try {
            Origin origin=originRepos.findById(id).stream().findFirst().orElse(null);
            if(level==0) originRepos.deleteById(id);
            else{
                if(level==1){
                    List<Component> components=componentRepos.findAllByOrigin(origin);
                    for (Component component:components) {
                        component.setOrigin(null);
                        componentRepos.save(component);
                    }
                    originRepos.delete(origin);
                }
                else if(level==2){
                    List<Component> components=componentRepos.findAllByOrigin(origin);
                    for (Component component:components) {
                        componentRepos.delete(component);
                    }
                    originRepos.delete(origin);
                }
            }
        }
        catch (Exception e){
            System.out.println(e.getMessage());
        }
    }
}
