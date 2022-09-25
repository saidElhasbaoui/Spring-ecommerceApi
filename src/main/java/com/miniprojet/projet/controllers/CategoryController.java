package com.miniprojet.projet.controllers;

import com.miniprojet.projet.beans.Category;
import com.miniprojet.projet.services.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/categories")
public class CategoryController {

    @Autowired
    CategoryService categoryService;

    @GetMapping("")
    List<Category> showAllCategories(){
        return categoryService.findAll();
    }

    @GetMapping("/find/{id}")
    Category showCategory(@PathVariable Long id){ return categoryService.findById(id); }

    @PostMapping("/insert")
    Category saveCategory(@RequestBody Category category){
        return categoryService.add(category);
    }

    @PutMapping("/update")
    Category updateCategory(@RequestBody Category category){
        return categoryService.update(category);
    }

    @DeleteMapping("/delete/{id}")
    void deleteCategory(@PathVariable Long id){
        categoryService.deleteById(id);
    }

    

}
