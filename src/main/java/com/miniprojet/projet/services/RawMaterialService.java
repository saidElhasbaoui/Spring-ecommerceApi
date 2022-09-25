package com.miniprojet.projet.services;

import com.miniprojet.projet.beans.RawMaterial;
import com.miniprojet.projet.repositories.RawMaterialRepos;
import com.miniprojet.projet.services.interfaces.IRawMaterial;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RawMaterialService implements IRawMaterial {

    @Autowired
    RawMaterialRepos rawMaterialRepos;

    //Logger logger = LoggerFactory.getLogger(CategoryService.class);

    @Override
    public List<RawMaterial> findAll() {
        return rawMaterialRepos.findAll();
    }

    @Override
    public RawMaterial findById(Long id) {
        return rawMaterialRepos.findById(id).stream().findFirst().orElse(null);
    }

    @Override
    public RawMaterial findByName(String name) {
        return rawMaterialRepos.findByName(name);
    }

    @Override
    public RawMaterial add(RawMaterial rawMaterial) {
        if(rawMaterial !=null){
            RawMaterial rm=rawMaterialRepos.findByName(rawMaterial.getName());
            if(rm==null){
                rawMaterialRepos.save(rawMaterial);
                return rawMaterial;
            }
            else{
                return rm;
            }
        }
        else
            return null;

    }

    @Override
    public RawMaterial update(RawMaterial rawMaterial) {
        rawMaterialRepos.save(rawMaterial);
        return rawMaterial;
    }

    @Override
    public void delete(RawMaterial rawMaterial) {

        try {
            rawMaterialRepos.delete(rawMaterial);
        }catch (Exception e){
            System.out.println(e.getMessage());
        }

    }

    @Override
    public void deleteById(Long id) {
        rawMaterialRepos.deleteById(id);
    }
}
