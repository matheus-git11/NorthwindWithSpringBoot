package com.github.matheusgit11.NorthwindWithSpringBoot.Service;

import com.github.matheusgit11.NorthwindWithSpringBoot.DTO.OrderDTO;
import com.github.matheusgit11.NorthwindWithSpringBoot.DTO.OrderDetailDTO;
import com.github.matheusgit11.NorthwindWithSpringBoot.Entity.*;
import com.github.matheusgit11.NorthwindWithSpringBoot.Repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class OrderService {

    @Autowired
    ProductRepository productRepository;
    @Autowired
    OrderRepository OrderRepository;
    @Autowired
    OrderDetailRepository DetailRepository;
    @Autowired
    CustomerRepository customerRepository;
    @Autowired
    EmployeeRepository employeeRepository;
    @Autowired
    ShipperRepository shipperRepository;

    public Optional<Order> createOrder(OrderDTO Order){
       List <OrderDetailDTO> detail = Order.getDetails();
       Optional<Customer> customer = customerRepository.findById(Order.getCustomerId());
       Optional<Employee> employee = employeeRepository.findById(Order.getEmployeeId());
       Optional<Shipper> shipper = shipperRepository.findById(Order.getShipperId());


       if(customer.isEmpty() || employee.isEmpty() || shipper.isEmpty()){
           return Optional.empty();
       }


       Order createdOrder = new Order();
            createdOrder.setCustomer(customer.get());
            createdOrder.setEmployee(employee.get());
            createdOrder.setOrderDate(Order.getOrderDate());
            createdOrder.setRequiredDate(Order.getRequiredDate());
            createdOrder.setShippedDate(Order.getShippedDate());
            createdOrder.setShipper(shipper.get());
            createdOrder.setFreight(Order.getFreight());
            createdOrder.setShipName(Order.getShipName());
            createdOrder.setShipAddress(Order.getShipAddress());
            createdOrder.setShipCity(Order.getShipCity());
            createdOrder.setShipRegion(Order.getShipRegion());
            createdOrder.setShipPostalCode(Order.getShipPostalCode());
            createdOrder.setShipCountry(Order.getShipCountry());


        Order savedOrder = OrderRepository.save(createdOrder);
        List<OrderDetail> OrderdetailList = new ArrayList<>();

        //agora fazer os details ja que ja salvamos a ordem e depois salvalas e adicionalas a ordem
        // apos isso atualizamos a ordem e retornamos ela ao controller

        for (OrderDetailDTO orderDetailDTO : detail) {
            int productId = orderDetailDTO.getProductId();
            Optional<Product> product = productRepository.findById(productId);

            OrderDetail eachOrderDetail = new OrderDetail();
            eachOrderDetail.setOrder(savedOrder);
            eachOrderDetail.setProduct(product.get());
            eachOrderDetail.setUnitPrice(product.get().getUnitPrice());
            eachOrderDetail.setQuantity(orderDetailDTO.getQuantity());
            eachOrderDetail.setDiscount(orderDetailDTO.getDiscount());

            DetailRepository.save(eachOrderDetail);

            OrderdetailList.add(eachOrderDetail);
        }

        savedOrder.setOrderDetails(OrderdetailList);
       Order newSavedOrder =OrderRepository.save(savedOrder);

        return Optional.of(newSavedOrder);
        }


        public List<Order> allOrders(){
        return OrderRepository.findAll();
        }
    }

