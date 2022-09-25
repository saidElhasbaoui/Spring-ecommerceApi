package com.miniprojet.projet.controllers;

import com.miniprojet.projet.beans.Product;
import com.miniprojet.projet.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/products")
public class ProductController {

    @Autowired
    ProductService productService;

    @GetMapping("")
    List<Product> showAllProducts(){
        return productService.findAll();
    }

    @GetMapping("/find/{id}")
    Product showProduct(@PathVariable Long id){
       return productService.findById(id);
    }

    @GetMapping("/corporate/{id}")
    List<Product> showAllProductsCorporate(@PathVariable Long id){
        return productService.findAllByCorporateId(id);
    }

    @GetMapping("/category/{id}")
    List<Product> showAllProductsCategory(@PathVariable Long id){
        return productService.findAllByCategoryId(id);
    }

    @PostMapping("/insert")
    Product addProduct(@RequestBody Product product){
       return productService.add(product);
    }

    @PutMapping("/update")
    Product updateProduct(@RequestBody Product product){
        return productService.update(product);
    }

    @DeleteMapping("/delete/{id}")
    void deleteProduct(@PathVariable Long id){
        productService.deleteById(id);
    }

}
