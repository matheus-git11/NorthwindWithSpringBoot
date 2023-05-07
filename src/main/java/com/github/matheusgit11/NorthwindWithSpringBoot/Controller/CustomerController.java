package com.github.matheusgit11.NorthwindWithSpringBoot.Controller;

import com.github.matheusgit11.NorthwindWithSpringBoot.Entity.Customer;
import com.github.matheusgit11.NorthwindWithSpringBoot.Repository.CustomerRepository;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/customers")
public class CustomerController {

    @Autowired
    CustomerRepository repository;

    @PostMapping
    public ResponseEntity<?> saveCustomer(@RequestBody Customer customer){
       Customer savedCustomer = repository.save(customer);
        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(savedCustomer.getCustomerId()).toUri();

        return  ResponseEntity.created(location).build();
    }

    @GetMapping
    public ResponseEntity<?> RetrieveAllCustomers(){
        List<Customer> CustomersList = repository.findAll();
        if(CustomersList.isEmpty()){
          return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(CustomersList);
        }

    @GetMapping("/{id}")
    public ResponseEntity<?> RetrieveCustomerByid(@PathVariable int id){
        Optional<Customer> customer = repository.findById(id);
        if(customer.isEmpty()){
          return  ResponseEntity.notFound().build();
        }

     return  ResponseEntity.ok(customer.get());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> DeleteCustomerById(@PathVariable int id){
        repository.deleteById(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> UpdateCustomer(@RequestBody Customer customer , @PathVariable int id){
        Optional<Customer> actualCustomer = repository.findById(id);
        if(actualCustomer.isEmpty()){
            return ResponseEntity.notFound().build();
        }else{
            Customer UpdatedCustomer = actualCustomer.get();
            UpdatedCustomer.setCompanyName(customer.getCompanyName());
            UpdatedCustomer.setContactName(customer.getContactName());
            UpdatedCustomer.setContactTitle(customer.getContactTitle());
            UpdatedCustomer.setAddress(customer.getAddress());
            UpdatedCustomer.setCity(customer.getCity());
            UpdatedCustomer.setRegion(customer.getRegion());
            UpdatedCustomer.setPostalCode(customer.getPostalCode());
            UpdatedCustomer.setCountry(customer.getCountry());
            UpdatedCustomer.setPhone(customer.getPhone());
            UpdatedCustomer.setFax(customer.getFax());
            repository.save(UpdatedCustomer);
        }

        return ResponseEntity.ok().build();
    }


}
