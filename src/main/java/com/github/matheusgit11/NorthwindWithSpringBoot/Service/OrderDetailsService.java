package com.github.matheusgit11.NorthwindWithSpringBoot.Service;

import com.github.matheusgit11.NorthwindWithSpringBoot.DTO.ReturnOrderDetailDTO;
import com.github.matheusgit11.NorthwindWithSpringBoot.Entity.OrderDetail;
import com.github.matheusgit11.NorthwindWithSpringBoot.Repository.OrderDetailRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Service
public class OrderDetailsService {

    @Autowired
    OrderDetailRepository repository;

    public List<ReturnOrderDetailDTO> retrieveAll(){
        List<OrderDetail> detailsList = repository.findAll();
        List<ReturnOrderDetailDTO> detailsRetrieveList = new ArrayList<>();

        for (OrderDetail orderDetail : detailsList) {
            ReturnOrderDetailDTO orderDto = new ReturnOrderDetailDTO();

           String customerName  = orderDetail.getOrder().getCustomer().getContactName();
           LocalDate orderDate = orderDetail.getOrder().getOrderDate();
           String productName  =  orderDetail.getProduct().getProductName();
           int unitPrice = orderDetail.getUnitPrice();
           int quantity = orderDetail.getQuantity();
           int discount = orderDetail.getDiscount();

           orderDto.setCustomerName(customerName);
           orderDto.setOrderDate(orderDate);
           orderDto.setProductName(productName);
           orderDto.setUnitPrice(unitPrice);
           orderDto.setQuantity(quantity);
           orderDto.setDiscount(discount);

           detailsRetrieveList.add(orderDto);
        }

        return detailsRetrieveList;
    }



    public List<ReturnOrderDetailDTO> retrieveById(int id){
        List<OrderDetail> detailsList = repository.findAll();
        List<ReturnOrderDetailDTO> detailsRetrieveList = new ArrayList<>();

        for (OrderDetail orderDetail : detailsList) {
           if(orderDetail.getOrder().getCustomer().getCustomerId() == id) {
                ReturnOrderDetailDTO orderDto = new ReturnOrderDetailDTO();

                String customerName = orderDetail.getOrder().getCustomer().getContactName();
                LocalDate orderDate = orderDetail.getOrder().getOrderDate();
                String productName = orderDetail.getProduct().getProductName();
                int unitPrice = orderDetail.getUnitPrice();
                int quantity = orderDetail.getQuantity();
                int discount = orderDetail.getDiscount();

                orderDto.setCustomerName(customerName);
                orderDto.setOrderDate(orderDate);
                orderDto.setProductName(productName);
                orderDto.setUnitPrice(unitPrice);
                orderDto.setQuantity(quantity);
                orderDto.setDiscount(discount);

                detailsRetrieveList.add(orderDto);
            }
        }

        return detailsRetrieveList;
    }
}
