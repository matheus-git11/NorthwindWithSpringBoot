package com.github.matheusgit11.NorthwindWithSpringBoot.Entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "orders")
public class Order {

    @Id
    @Column(name = "orderid")
    private Integer orderId;

    @ManyToOne
    @JoinColumn(name = "customerid")
    private Customer customer;

    @ManyToOne
    @JoinColumn(name = "employeeid")
    private Employee employee;

    @Column(name = "orderdate")
    private LocalDate orderDate;

    @Column(name = "requireddate")
    private LocalDate requiredDate;

    @Column(name = "shippeddate")
    private LocalDate shippedDate;

    @ManyToOne
    @JoinColumn(name = "shipvia")
    private Shipper shipper;

    @Column(name = "freight")
    private BigDecimal freight;

    @Column(name = "shipname")
    private String shipName;

    @Column(name = "shipaddress")
    private String shipAddress;

    @Column(name = "shipcity")
    private String shipCity;

    @Column(name = "shipregion")
    private String shipRegion;

    @Column(name = "shippostalcode")
    private String shipPostalCode;

    @Column(name = "shipcountry")
    private String shipCountry;

    @OneToMany(mappedBy = "order")
    private List<OrderDetail> orderDetails;

    // getters and setters
}
