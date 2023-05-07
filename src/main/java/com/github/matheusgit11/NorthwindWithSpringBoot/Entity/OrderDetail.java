package com.github.matheusgit11.NorthwindWithSpringBoot.Entity;

import jakarta.persistence.*;

import java.math.BigDecimal;

@Entity
@Table(name = "order_details")
public class OrderDetail {

    @Id
    @ManyToOne
    @JoinColumn(name = "orderid")
    private Order order;

    @Id
    @ManyToOne
    @JoinColumn(name = "productid")
    private Product product;

    @Column(name = "unitprice")
    private BigDecimal unitPrice;

    @Column(name = "quantity")
    private Short quantity;

    @Column(name = "discount")
    private BigDecimal discount;


}
