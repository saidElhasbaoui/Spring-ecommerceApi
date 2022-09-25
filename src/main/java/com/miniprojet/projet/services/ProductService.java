package com.miniprojet.projet.services;

import com.miniprojet.projet.beans.Category;
import com.miniprojet.projet.beans.Component;
import com.miniprojet.projet.beans.Corporate;
import com.miniprojet.projet.beans.Product;
import com.miniprojet.projet.repositories.ComponentRepos;
import com.miniprojet.projet.repositories.ProductRepos;
import com.miniprojet.projet.services.interfaces.IProduct;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService implements IProduct {

    @Autowired
    ProductRepos productRepos;

    @Autowired
    CorporateService corporateService;

    @Autowired
    CategoryService categoryService;

    @Autowired
    ComponentRepos componentRepos;

    //Logger logger = LoggerFactory.getLogger(CategoryService.class);

    @Override
    public List<Product> findAll() {
        return productRepos.findAll();
    }

    @Override
    public Product findById(Long id) {
        return productRepos.findById(id).stream().findFirst().orElse(null);
    }

    @Override
    public Product add(Product product) {

        if(product !=null){

            Corporate corporate=product.getCorporate();
            if(corporate.getId()!=null){
                corporate=corporateService.findById(corporate.getId());
            }
            else{
                corporate=corporateService.add(corporate);
            }
            product.setCorporate(corporate);

            Category category=product.getCategory();
            if(category.getId()!=null){
                category=categoryService.findById(category.getId());
            }
            else{
                category=categoryService.add(category);
            }
            product.setCategory(category);

            productRepos.save(product);
        }

        return product;
    }

    @Override
    public Product update(Product product) {
        productRepos.save(product);
        return product;
    }

    @Override
    public void delete(Product product) {
        try {
            productRepos.delete(product);
        }catch (Exception e){
            System.out.println(e.getMessage());
        }

    }

    @Override
    public void deleteById(Long id) {

        Product product=productRepos.findById(id).stream().findFirst().orElse(null);
        if(product !=null){
            List<Component> components=componentRepos.findAllByProduct(product);
            componentRepos.deleteAll(components);
            productRepos.deleteById(id);
        }

    }

    @Override
    public List<Product> findAllByCorporate(Corporate corporate) {
        return productRepos.findAllByCorporate(corporate);
    }

    @Override
    public List<Product> findAllByCategory(Category category) {
        return productRepos.findAllByCategory(category);
    }

    @Override
    public List<Product> findAllByCorporateId(Long id) {
        Corporate corporate=corporateService.findById(id);
        return this.findAllByCorporate(corporate);
    }

    @Override
    public List<Product> findAllByCategoryId(Long id) {
        Category category=categoryService.findById(id);
        return this.findAllByCategory(category);
    }

    @Override
    public Product findByName(String name) {
        return productRepos.findByName(name);
    }



}
