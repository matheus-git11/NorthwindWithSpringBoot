package com.github.matheusgit11.NorthwindWithSpringBoot.Controller;

import com.github.matheusgit11.NorthwindWithSpringBoot.Entity.Customer;
import com.github.matheusgit11.NorthwindWithSpringBoot.Entity.Employee;
import com.github.matheusgit11.NorthwindWithSpringBoot.Repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/employees")
public class EmployeeController {

    @Autowired
    EmployeeRepository repository;

    @PostMapping
    public ResponseEntity<?> createEmployee(@RequestBody Employee employee){
        Employee CreatedEmployee = repository.save(employee);
        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(CreatedEmployee.getEmployeeId()).toUri();

        return  ResponseEntity.created(location).build();
    }

    @GetMapping
    public ResponseEntity<?> getAllEmployees(){
        List<Employee> retrievedEmployees = repository.findAll();
        if(retrievedEmployees.isEmpty()){
            return ResponseEntity.noContent().build();
        }

        return ResponseEntity.ok(retrievedEmployees);
    }
}
