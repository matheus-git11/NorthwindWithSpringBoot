package com.github.matheusgit11.NorthwindWithSpringBoot.Controller;

import com.github.matheusgit11.NorthwindWithSpringBoot.DTO.ProductDTO;
import com.github.matheusgit11.NorthwindWithSpringBoot.Entity.Product;
import com.github.matheusgit11.NorthwindWithSpringBoot.Service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("products")
public class ProductController {

    @Autowired
    ProductService service;

    @PostMapping
    public ResponseEntity<?> createProduct(@RequestBody ProductDTO product){
        Optional<Product> newProduct = service.save(product);

        if(newProduct.isEmpty()){
            return ResponseEntity.internalServerError().build();
        }

        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(newProduct.get().getProductId()).toUri();

        return  ResponseEntity.created(location).build();
    }

    @GetMapping
    public ResponseEntity<?> retrieveAllProducts(){
        List<Product> productList = service.getAll();
        return ResponseEntity.ok(productList);
    }
}
