package com.github.matheusgit11.NorthwindWithSpringBoot.Controller;

import com.github.matheusgit11.NorthwindWithSpringBoot.Entity.Suppliers;
import com.github.matheusgit11.NorthwindWithSpringBoot.Repository.SuppliersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/suppliers")
public class SuppliersController {

    @Autowired
    SuppliersRepository repository;

@PostMapping
public ResponseEntity<?> createSupplier(@RequestBody Suppliers supplier){
    Suppliers createdSupplier = repository.save(supplier);

    URI location = ServletUriComponentsBuilder
            .fromCurrentRequest()
            .path("/{id}")
            .buildAndExpand(createdSupplier.getSupplierId()).toUri();

    return  ResponseEntity.created(location).build();
}

@GetMapping
public ResponseEntity<?> getAllSuppliers(){
    List<Suppliers> suppliers = repository.findAll();
    if(suppliers.isEmpty()){
       return ResponseEntity.noContent().build();
    }

    return ResponseEntity.ok(suppliers);
}

}
