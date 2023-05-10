package com.github.matheusgit11.NorthwindWithSpringBoot.Controller;

import com.github.matheusgit11.NorthwindWithSpringBoot.DTO.ReturnOrderDetailDTO;
import com.github.matheusgit11.NorthwindWithSpringBoot.Service.OrderDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/details")
public class OrderDetailsController {

    @Autowired
    OrderDetailsService service;

    @GetMapping
    public ResponseEntity<?> getAllDetails(){
        List<ReturnOrderDetailDTO> RetrievedDetails = service.retrieveAll();
        if(RetrievedDetails.isEmpty()){
            return ResponseEntity.noContent().build();
        }

        return ResponseEntity.ok(RetrievedDetails);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getDetailsById(@PathVariable int id){
      List<ReturnOrderDetailDTO> details =  service.retrieveById(id);
        if(details.isEmpty()){
            return ResponseEntity.noContent().build();
        }

        return ResponseEntity.ok(details);
    }
}
