package com.miniprojet.projet.services;


import com.miniprojet.projet.beans.Corporate;
import com.miniprojet.projet.repositories.CorporateRepos;
import com.miniprojet.projet.services.interfaces.ICorporate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CorporateService implements ICorporate {

    @Autowired
    CorporateRepos corporateRepos;

    //Logger logger = LoggerFactory.getLogger(CategoryService.class);

    @Override
    public List<Corporate> findAll() {
        //logger.info("Consultation of all corporates");
        return corporateRepos.findAll();
    }

    @Override
    public Corporate findById(Long id) {
        return corporateRepos.findById(id).stream().findFirst().orElse(null);
    }

    @Override
    public Corporate add(Corporate corporate) {
        if(corporate!=null){
            Corporate corp=corporateRepos.findByName(corporate.getName());
            if(corp==null){
                corporateRepos.save(corporate);
                return corporate;
            }
            else{
                return corp;
            }
        }
        else
            return null;
    }

    @Override
    public Corporate update(Corporate corporate) {
        corporateRepos.save(corporate);
        return corporate;
    }

    @Override
    public void delete(Corporate corporate) {
        corporateRepos.delete(corporate);
    }

    @Override
    public void deleteById(Long id) {
        corporateRepos.deleteById(id);
    }

    @Override
    public Corporate findByName(String name) {
        return corporateRepos.findByName(name);
    }


}
