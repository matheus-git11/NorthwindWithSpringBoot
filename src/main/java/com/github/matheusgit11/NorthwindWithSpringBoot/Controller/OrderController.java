package com.github.matheusgit11.NorthwindWithSpringBoot.Controller;

import com.github.matheusgit11.NorthwindWithSpringBoot.DTO.OrderDTO;
import com.github.matheusgit11.NorthwindWithSpringBoot.Entity.Order;
import com.github.matheusgit11.NorthwindWithSpringBoot.Service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/order")
public class OrderController {

    @Autowired
    OrderService service;

    @PostMapping
    public ResponseEntity<?> createOrder(@RequestBody OrderDTO order){
        Optional<Order> createdOrder = service.createOrder(order);
        if(createdOrder.isEmpty()){
            return ResponseEntity.badRequest().build();
        }

        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(createdOrder.get().getOrderId()).toUri();

        return  ResponseEntity.created(location).build();
    }

    @GetMapping
    public ResponseEntity<?> returnAllOrders(){
        List<Order> orders= service.allOrders();
       return ResponseEntity.ok(orders);
    }
}
