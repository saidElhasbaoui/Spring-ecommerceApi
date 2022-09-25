package com.miniprojet.projet.services;

import com.miniprojet.projet.beans.Category;
import com.miniprojet.projet.repositories.CategoryRepos;
import com.miniprojet.projet.services.interfaces.ICategory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryService implements ICategory {

    @Autowired
    CategoryRepos categoryRepos;

    //Logger logger = LoggerFactory.getLogger(CategoryService.class);

    @Override
    public List<Category> findAll() {
        //logger.info("Consultation of all categories !");
        return categoryRepos.findAll();
    }

    @Override
    public Category add(Category category) {
        if(category!=null){
            Category ca=categoryRepos.findByName(category.getName());
            if(ca==null){
                categoryRepos.save(category);
                //logger.info("New element has been saved : "+category);
                return category;
            }
            else{
                //logger.info("Failed to add : "+category+" the name of this element is already exist");
                return ca;
            }
        }
        else
            return null;

    }

    @Override
    public Category update(Category category) {
        //logger.info("Element has been updated : "+category);
        return categoryRepos.save(category);
    }

    @Override
    public void delete(Category category) {
        categoryRepos.delete(category);
        //logger.info("Element has been removed : "+category);
    }

    @Override
    public void deleteById(Long id) {
        try {
            categoryRepos.deleteById(id);
            //logger.info("Category has been removed with ID = "+id);
        }
        catch (Exception e){
            //logger.info(e.getMessage());
        }

    }

    @Override
    public Category findById(Long id) {
        Category category=categoryRepos.findById(id).stream().findFirst().orElse(null);
        if(category !=null){
            //logger.info("Consultation of the element : "+category);
        }
        return category;
    }

    @Override
    public Category findByName(String name) {
        Category category=categoryRepos.findByName(name);
        if(category !=null){
            //logger.info("Consultation of the element : "+category);
        }
        return category;
    }

}
