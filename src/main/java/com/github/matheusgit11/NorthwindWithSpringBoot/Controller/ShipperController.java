package com.github.matheusgit11.NorthwindWithSpringBoot.Controller;

import com.github.matheusgit11.NorthwindWithSpringBoot.Entity.Shipper;
import com.github.matheusgit11.NorthwindWithSpringBoot.Repository.ShipperRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/shipper")
public class ShipperController {

    @Autowired
    ShipperRepository repository;

@PostMapping
public ResponseEntity<?> createShipper(@RequestBody Shipper shipper){
    Shipper savedShipper = repository.save(shipper);
    URI location = ServletUriComponentsBuilder
            .fromCurrentRequest()
            .path("/{id}")
            .buildAndExpand(savedShipper.getShipperId()).toUri();

    return  ResponseEntity.created(location).build();
}

@GetMapping
public ResponseEntity<?> getAllShippers(){
    List<Shipper> shippers = repository.findAll();

    if(shippers.isEmpty()){
        return ResponseEntity.noContent().build();
    }
    return ResponseEntity.ok(shippers);
    }
}
