package com.github.matheusgit11.NorthwindWithSpringBoot.Entity;

import jakarta.persistence.*;

import java.math.BigDecimal;
import java.util.List;

@Entity
@Table(name = "products")
public class Product {

    @Id
    @Column(name = "productid")
    private Integer productId;

    @Column(name = "productname")
    private String productName;

    @ManyToOne
    @JoinColumn(name = "supplierid")
    private Suppliers supplier;

    @ManyToOne
    @JoinColumn(name = "categoryid")
    private Category category;

    @Column(name = "quantityperunit")
    private String quantityPerUnit;

    @Column(name = "unitprice")
    private BigDecimal unitPrice;

    @Column(name = "unitsinstock")
    private Short unitsInStock;

    @Column(name = "unitsonorder")
    private Short unitsOnOrder;

    @Column(name = "reorderlevel")
    private Short reorderLevel;

    @Column(name = "discontinued")
    private boolean discontinued;

    @OneToMany(mappedBy = "product")
    private List<OrderDetail> orderDetails;

}
