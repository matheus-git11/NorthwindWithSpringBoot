package com.github.matheusgit11.NorthwindWithSpringBoot.Controller;

import com.github.matheusgit11.NorthwindWithSpringBoot.Entity.Category;
import com.github.matheusgit11.NorthwindWithSpringBoot.Repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/category")
public class CategoryController {

    @Autowired
    CategoryRepository repository;

    @PostMapping
    public ResponseEntity<?> SaveCategory(@RequestBody Category category){
        Category savedCategory =  repository.save(category);

        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(savedCategory.getId()).toUri();

       return ResponseEntity.created(location).build();
    }


    @GetMapping
    public ResponseEntity<?> getAllCategories(){
        List<Category> categories = repository.findAll();
        if(categories.isEmpty()){
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(categories);
    }


}
